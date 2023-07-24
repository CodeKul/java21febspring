package com.codekul.java21febspring.dbrefmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SportsRepo extends MongoRepository<Sports,String> {
}
