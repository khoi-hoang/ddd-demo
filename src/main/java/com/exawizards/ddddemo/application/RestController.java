package com.exawizards.ddddemo.application;

import com.exawizards.ddddemo.domain.service.TimestampService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequiredArgsConstructor
public class RestController {

    private final TimestampService timestampService;

    @PutMapping("/timestamp")
    public ResponseEntity<Map<String, String>> setTimestamp() {
        timestampService.snapshot();

        return new ResponseEntity<>(
            Map.of("message", "Success"),
            HttpStatus.OK
        );
    }

    @GetMapping("/timestamp")
    public ResponseEntity<Map<String, Long>> getTimestamp() {

        return new ResponseEntity<>(
            Map.of("message", timestampService.getLatestSnapshot()),
            HttpStatus.OK
        );
    }
}
