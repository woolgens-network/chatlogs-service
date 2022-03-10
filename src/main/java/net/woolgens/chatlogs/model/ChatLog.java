package net.woolgens.chatlogs.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.List;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
@MongoEntity(collection = "chatlogs")
public class ChatLog {

    @BsonId
    private String id;
    private long registered;
    private ChatLogPlayer issuer;
    private ChatLogPlayer target;
    private List<ChatLogEntry> entries;


}
