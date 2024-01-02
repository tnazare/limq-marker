package com.limq.api;

import com.limq.model.Match;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "matches")
public interface MatchApi extends CrudlApi<Match> {
}
