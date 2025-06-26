package org.seclass.greenroad.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Req3 {
    private Long id;
    private Long reqId;
    private Long type;
    private Long moneyNum;
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
