package org.seclass.greenroad.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Student {

    private Long id;             // 主键，自增
    private String name;         // 姓名
    private Integer age;         // 年龄
    private String idNum;          // 学号（建议唯一）
    private Long grade;          // 年级
    private String pro;          // 专业
    private String xveYvan;      // 不明字段含义（保留）
    private String clazz;        // 班级
    private Integer daiKuan;     // 是否贷款（建议改成 boolean 或 tinyint）
    private String phone;        // 手机号
    private String password;     // 密码，建议用 String 存储加密值
    private Integer collegeId;   // 所属学院 ID
    private Integer academyId;   // 所属系 ID
    private Integer counselorId; // 辅导员 ID

    private Boolean isDeleted;        // 逻辑删除标志
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}
