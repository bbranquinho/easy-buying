package org.wpattern.easy.buying.neighborhood;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.NEIGHBORHOOD_PATH)
public class NeighborhoodResource extends GenericService<Neighborhood,Long> {
}
