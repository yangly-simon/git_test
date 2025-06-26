package org.seclass.greenroad.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Item {
    private Long id;
    private String imgName;
    private String img; // longtext 对应 String
    private String itemName;
    private String size;
    private String intro; // longtext 对应 String
    private String type;  // longtext 对应 String
    private Long price;
    private Long sex;
    private Boolean necessory;
    private Boolean gift;
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
