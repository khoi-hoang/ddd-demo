package com.exawizards.ddddemo.domain.repository;

public interface TimestampRepository {
    void set(long timestamp);
    long get();
}
