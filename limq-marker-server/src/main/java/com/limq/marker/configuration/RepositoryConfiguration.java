package com.limq.marker.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.limq.*"})
@EntityScan("com.limq.*")
public class RepositoryConfiguration {
}
