package com.limq.api;

import com.limq.model.Improvisation;
import com.limq.model.ImprovisationTeam;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "improvisations/teams")
public interface ImprovisationTeamApi extends CrudlApi<ImprovisationTeam> {
}
