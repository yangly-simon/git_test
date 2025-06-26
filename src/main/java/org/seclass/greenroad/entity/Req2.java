package org.seclass.greenroad.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Req2 {
    private Long id;
    private Long reqId;
    private Long num;
    private String reason; // longtext 对应 String
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
