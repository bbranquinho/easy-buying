package org.wpattern.easy.buying.notification_template;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.notification_template.Notification_Template;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;


@RestController
@RequestMapping(path = ResourcePaths.NOTIFICATION_TEMPLATE_PATH)
public class Notification_TemplateResource extends GenericService<Notification_Template, Long> {
}
