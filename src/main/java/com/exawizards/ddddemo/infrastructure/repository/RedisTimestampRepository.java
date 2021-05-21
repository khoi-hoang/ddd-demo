package com.exawizards.ddddemo.infrastructure.repository;

import com.exawizards.ddddemo.domain.repository.TimestampRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Primary
public class RedisTimestampRepository implements TimestampRepository {

    private final StringRedisTemplate redisTemplate;

    @Override
    public void set(long timestamp) {
        redisTemplate.opsForValue().set("timestamp", String.valueOf(timestamp));
    }

    @Override
    public long get() {
        return Long.parseLong(Objects.requireNonNull(redisTemplate.opsForValue().get("timestamp")));
    }
}
