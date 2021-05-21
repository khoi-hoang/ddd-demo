package com.exawizards.ddddemo.domain.service;

public interface TimestampService {
    void snapshot();
    long getLatestSnapshot();
}
