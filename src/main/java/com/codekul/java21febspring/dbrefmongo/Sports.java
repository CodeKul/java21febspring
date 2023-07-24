package com.codekul.java21febspring.dbrefmongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Getter
@Setter
public class Sports {

    @MongoId
    private String id;

    private String sportName;

    @DBRef
    private Players players;

}
