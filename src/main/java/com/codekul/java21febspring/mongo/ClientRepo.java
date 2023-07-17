package com.codekul.java21febspring.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepo extends MongoRepository<Client,String> {
}
