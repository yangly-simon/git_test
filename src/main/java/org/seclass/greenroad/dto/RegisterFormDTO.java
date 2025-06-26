package org.seclass.greenroad.dto;

import lombok.Data;

@Data
public class RegisterFormDTO {
    private int counselorId;
    private int collegeId;
    private int academyId;
    private String name;         // 姓名
    private int age;
    private Long idNum;          // 学号
    private Long grade;          // 年级
    private String pro;// 专业
    private String XveYvan;
    private String clazz;        // 班级
    private int DaiKuan;
    private String phone;          // 手机号
    private Long password;       // 密码（建议改成 String）

}
