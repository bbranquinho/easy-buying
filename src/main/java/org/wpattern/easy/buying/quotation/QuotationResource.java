package org.wpattern.easy.buying.quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.notification.Notification;
import org.wpattern.easy.buying.notification.NotificationRepository;
import org.wpattern.easy.buying.notification.NotificationResource;
import org.wpattern.easy.buying.notification_template.NotificationTemplateRepository;
import org.wpattern.easy.buying.notification_template.NotificationTemplateResource;
import org.wpattern.easy.buying.security.CurrentUser;
import org.wpattern.easy.buying.supplier.SupplierRepository;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.easy.buying.utils.Constants;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.QUOTATION_PATH)
public class QuotationResource extends GenericService<Quotation, Long> {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuotationResource quotationResource;

    @Autowired
    private SupplierRepository supplier;

    @Autowired
    private NotificationResource notificationResource;

    @Autowired
    private NotificationRepository notificationRepository;


    @Autowired
    private NotificationTemplateRepository notificationTemplateRepository;

    @Autowired
    private NotificationTemplateResource notificationTemplateResource;



    @Override
    public Quotation insert(@RequestBody Quotation  quotation) {
        quotation.setSupplier(this.supplier.getOne(1L));

        try{
            super.insert(quotation);
        } catch (Exception e){

        }

        notificationResource.sendMail(gerarNotificacaoQuotation(quotation));

        return quotation;
}

    private Notification gerarNotificacaoQuotation(Quotation quotation) {


    Notification notification = new Notification(Constants.FROM,
                                                 currentUser.getActiveUser().getEmail(),
                                                 Constants.SUBJECT_NEW_QUOTATION,
                                                 notificationTemplateRepository.getOne(1L).getDefault_message(),
                                                 notificationTemplateRepository.getOne(1L),
                                                 quotation);

        notificationResource.sendMail(notification);
        return notification;
    }

}
