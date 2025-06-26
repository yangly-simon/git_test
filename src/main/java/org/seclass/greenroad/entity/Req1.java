package org.seclass.greenroad.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Req1 {
    private Long id;
    private Long reqId;
    private Boolean Xvefei;
    private Boolean Zhusu;
    private Long moneyXvefei;
    private Long moneyZhusu;
    private Long reason;
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
