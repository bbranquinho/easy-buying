package org.wpattern.easy.buying.notification_type;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.notification_type.Notification_Type;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.NOTIFICATION_TYPE_PATH)
public class Notification_TypeResource extends GenericService<Notification_Type, Long> {
}
