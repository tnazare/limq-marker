package com.limq.api;

import com.limq.model.Team;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "teams")
public interface TeamApi extends CrudlApi<Team> {
}
