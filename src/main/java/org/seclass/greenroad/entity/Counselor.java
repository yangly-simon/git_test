package org.seclass.greenroad.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Counselor {
    private Long id;
    private Long rooterId;
    private String user;
    private Long grade;
    private String college;
    private String phone;
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
