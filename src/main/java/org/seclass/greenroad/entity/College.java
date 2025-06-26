package org.seclass.greenroad.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class College {
    private int id;
    private int rooterId;
    private String user;
    private String password;
    private String phone;
    private boolean is_deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
