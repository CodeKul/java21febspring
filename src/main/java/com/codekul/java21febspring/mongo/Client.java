package com.codekul.java21febspring.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Getter
@Setter
public class Client {

    @MongoId
    private String id;

    private String name;

    private String address;

}
