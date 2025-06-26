package org.seclass.greenroad.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Req {
    private Long id;
    private Long req3Id;
    private Long greenroadId;
    private Long req1Id;
    private Long req2Id;
    private Long studentId;
    private Long idNum;
    private Long type;
    private Long state;
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
