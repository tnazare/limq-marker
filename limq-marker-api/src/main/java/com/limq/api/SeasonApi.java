package com.limq.api;

import com.limq.model.Season;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "seasons")
public interface SeasonApi extends CrudlApi<Season> {
}
