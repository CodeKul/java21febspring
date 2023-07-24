package com.codekul.java21febspring.dbrefmongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collation = "players")
@Getter
@Setter
public class Players {

    @MongoId
    private String id;

    private String playerName;


}
