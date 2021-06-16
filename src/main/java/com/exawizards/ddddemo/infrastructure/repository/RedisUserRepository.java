package com.exawizards.ddddemo.infrastructure.repository;

import com.exawizards.ddddemo.domain.exception.UserRepositoryException;
import com.exawizards.ddddemo.domain.model.User;
import com.exawizards.ddddemo.domain.repository.UserRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisUserRepository implements UserRepository {
    private static final String REDIS_HASH_KEY_USERNAME = "username";
    private static final String REDIS_HASH_KEY_ORGANIZATION = "organization";

    private final StringRedisTemplate redisTemplate;

    @Override
    public void saveUser(User user) throws UserRepositoryException {
        try {
            redisTemplate.opsForHash().putAll(
                String.valueOf(user.getId()),
                Map.of(
                    REDIS_HASH_KEY_USERNAME,
                    user.getName(),
                    REDIS_HASH_KEY_ORGANIZATION,
                    user.getOrganization()
                )
            );
        } catch (Exception e) {
            throw new UserRepositoryException("Failed to save user hash", e);
        }
    }

    @Override
    public void dropUser(User user) throws UserRepositoryException {
        try {
            redisTemplate.delete(String.valueOf(user.getId()));
        } catch (Exception e) {
            throw new UserRepositoryException("failed to drop Redis key", e);
        }
    }
}
