package com.exawizards.ddddemo.domain.service;

import org.springframework.stereotype.Service;

@Service
public class LastTwoDigitCalcEngine implements CalculationEngine{

    @Override
    public long calculate(long num) {
        return num % 100;
    }
}
