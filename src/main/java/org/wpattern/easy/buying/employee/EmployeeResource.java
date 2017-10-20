package org.wpattern.easy.buying.employee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.EMPLOYEE_PATH)
public class EmployeeResource extends GenericService<Employee, Long> {
}
