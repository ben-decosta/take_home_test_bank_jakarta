package org.book.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(
    name = "spring.cache.type",
    havingValue = "redis",
    matchIfMissing = false
)
@EnableCaching
@Configuration
public class RedisConfig {
    
}
