package com.exawizards.ddddemo.domain.service;

import com.exawizards.ddddemo.domain.repository.TimestampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimestampServiceImpl implements TimestampService {
    private final TimestampRepository timestampRepository;
    private final CalculationEngine calculationEngine;

    @Override
    public void snapshot() {
        long curTime = System.currentTimeMillis() / 1000L;

        // Put the raw implementation code here
        // Complicate our exsting code, modify/update our UT

        long result = calculationEngine.calculate(curTime);
        timestampRepository.set(result);
    }

    @Override
    public long getLatestSnapshot() {
        return timestampRepository.get();
    }
}
