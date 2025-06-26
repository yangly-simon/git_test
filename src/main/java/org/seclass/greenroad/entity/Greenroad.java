package org.seclass.greenroad.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Greenroad {
    private Long id;
    private Long collegeId;
    private LocalDateTime reqStrat;
    private LocalDateTime reqEnd;
    private LocalDateTime uploadDdl;
    private Long year;
    private Long fund;
    private Long state1;
    private Long state2;
    private Long state3;
    private Long max;
    private Long batch;
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
