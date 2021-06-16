package com.exawizards.ddddemo.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.*;
import com.exawizards.ddddemo.domain.exception.UserRepositoryException;
import com.exawizards.ddddemo.domain.model.User;
import com.exawizards.ddddemo.domain.repository.UserRepository;
import com.exawizards.ddddemo.infrastructure.config.RedisTemplateBean;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.data.redis.core.StringRedisTemplate;

@TestInstance(Lifecycle.PER_CLASS)
class RedisUserRepositoryTest {
    private StringRedisTemplate redisTemplate;
    private UserRepository underTest;

    @BeforeAll
    void setAllUp() {
        // FIXME: Spin a Docker container instead.
        redisTemplate = new RedisTemplateBean().redisTemplate();
        redisTemplate.afterPropertiesSet();
    }

    @BeforeEach
    void setEachUp() {
        underTest = new RedisUserRepository(redisTemplate);
    }

    @AfterAll
    static void tearDown() {
        // FIXME: Drop the Docker container.
    }

    @Test
    void saveUser() throws UserRepositoryException {
        User dummyUser = new User("abc", "khoi", "exa");
        underTest.saveUser(dummyUser);

        assertEquals("khoi", redisTemplate.opsForHash().get("abc", "username"));
        assertEquals("exa", redisTemplate.opsForHash().get("abc", "organization"));
    }

    @Test
    void dropUser() {
    }
}
