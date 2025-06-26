package org.seclass.greenroad.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Academy {
    private Long id;             // 主键，自增
    private Long rooterId;       // 审核人 ID 或负责人 ID
    private Long greenroadId;    // 绿色通道记录 ID
    private String user;         // 用户名或用户字段（建议为 userId）
    private String password;     // 密码（如确实需要）
    private String major;        // 专业名称
    private Long phone;          // 手机号
    private Long quota;          // 名额或补助额度
    private Boolean isDeleted;   // 逻辑删除标记
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
