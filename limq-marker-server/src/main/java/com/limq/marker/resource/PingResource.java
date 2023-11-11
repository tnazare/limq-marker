package com.limq.marker.resource;

import com.limq.api.PingApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingResource implements PingApi {
    @Override
    public String ping() {
        return "pong";
    }
}
