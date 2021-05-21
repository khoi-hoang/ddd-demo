package com.exawizards.ddddemo.application;

import com.exawizards.ddddemo.domain.service.TimestampService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandLineExecutor implements org.springframework.boot.CommandLineRunner {
    private final TimestampService timestampService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting...");
        timestampService.snapshot();
        log.info("Done");
    }
}
