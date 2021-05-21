package com.exawizards.ddddemo.infrastructure.repository;

import com.exawizards.ddddemo.domain.repository.TimestampRepository;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MongoTimestampRepository implements TimestampRepository {

    private final MongoDatabase mongoDatabase;

    @Override
    public void set(long timestamp) {
        var document = new Document();
        document.append("timestamp", timestamp);
        mongoDatabase.getCollection("timestamp").insertOne(document);
    }

    @Override
    public long get() {
        // TODO: Implement me!
        return 0;
    }
}
