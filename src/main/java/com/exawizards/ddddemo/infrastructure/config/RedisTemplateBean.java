package com.exawizards.ddddemo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisTemplateBean {

    @Bean
    public StringRedisTemplate redisTemplate() {
        var template = new StringRedisTemplate();
        template.setConnectionFactory(new JedisConnectionFactory());
        return template;
    }
}
