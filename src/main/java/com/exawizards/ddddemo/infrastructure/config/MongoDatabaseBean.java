package com.exawizards.ddddemo.infrastructure.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDatabaseBean {
    @Bean
    public MongoDatabase mongoDatabase() {
        var mongo = new MongoClient( "localhost" , 27017 );
        return mongo.getDatabase("app");
    }
}
