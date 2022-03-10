package net.woolgens.chatlogs.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import net.woolgens.chatlogs.model.ChatLog;

import javax.enterprise.context.ApplicationScoped;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@ApplicationScoped
public class ChatLogsRepository implements PanacheMongoRepositoryBase<ChatLog, String> {
}
