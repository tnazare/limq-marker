package com.limq.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface PingApi {
    @GetMapping("/ping")
    String ping();
}
