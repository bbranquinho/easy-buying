package org.wpattern.easy.buying.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.productrequest.ProductRequest;
import org.wpattern.easy.buying.productrequest.ProductRequestRepository;
import org.wpattern.easy.buying.utils.ApplicationLogger;
import org.wpattern.easy.buying.utils.Constants;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = ResourcePaths.NOTIFICATION_PATH)
public class NotificationResource extends GenericService<Notification, Long> {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ProductRequestRepository productRequestRepository;

    private static final ApplicationLogger logger = ApplicationLogger.getInstance();

    private void send(Notification eParams) {

        if(eParams.getNotification_template() != null &&
                eParams.getNotification_template().getNotification_type().getType().equalsIgnoreCase(Constants.EMAIL.toString())) {
            try {
                sendHtmlMail(eParams);
            } catch (MessagingException e) {
                logger.error("Erro ao Enviar Email: {} Error = {}", eParams.getDestinatario(), e.getMessage());
            }
        } else {

            sendPlainTextMail(eParams);
        }

    }

    private void sendHtmlMail(Notification eParams) throws MessagingException {

        boolean isHtml = true;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(eParams.getDestinatario());
        helper.setReplyTo(eParams.getRemetente());
        helper.setFrom(eParams.getRemetente());
        helper.setSubject(eParams.getSubject());
        helper.setText(eParams.getMessage(), isHtml);

        mailSender.send(message);
        notificationRepository.save(eParams);

    }

    private void sendPlainTextMail(Notification eParams) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        eParams.getDestinatario();
        mailMessage.setTo(eParams.getDestinatario());
        mailMessage.setReplyTo(eParams.getRemetente());
        mailMessage.setFrom(eParams.getRemetente());
        mailMessage.setSubject(eParams.getSubject());
        mailMessage.setText(eParams.getMessage());

        mailSender.send(mailMessage);
        notificationRepository.save(eParams);
    }


    public void sendMail(Notification notificationIn) {

        String from = notificationIn.getRemetente();
        String to = notificationIn.getDestinatario();
        String subject = notificationIn.getSubject();

        Map<String, String> replacements = new HashMap<String, String>();

        ProductRequest productRequest = productRequestRepository.findOne(notificationIn.getQuotation_id().getProductRequest().getId());

        if(productRequest != null &&
                productRequest.getUser() != null &&
                productRequest.getUser().getName() != null ) {

            replacements.put("user", productRequest.getUser().getName());
        }

        SimpleDateFormat sdff = new SimpleDateFormat("dd/MM/yyyy");
        String dia = (sdff.format(new Date()));

        replacements.put("today", dia);

        if(notificationIn.getNotification_template() != null &&
                notificationIn.getNotification_template().getDefault_message() != null){

            String message = notificationIn.getNotification_template().getDefault_message(replacements);

            Notification notificationOut = new Notification(from, to, subject,message, notificationIn.getNotification_template(),notificationIn.getQuotation_id());

            this.send(notificationOut);
        }
    }
}
