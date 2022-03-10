package net.woolgens.chatlogs.model;

import lombok.Data;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
public class ChatLogEntry {

    private ChatLogPlayer executor;
    private long executed;
    private String type;
    private String value;
}
