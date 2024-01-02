package com.limq.api;

import com.limq.model.Improvisation;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "improvisations")
public interface ImprovisationApi extends CrudlApi<Improvisation> {
}
