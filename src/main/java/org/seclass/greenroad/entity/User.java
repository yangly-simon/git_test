package org.seclass.greenroad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("users")
@Builder
@EqualsAndHashCode
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private String email;

    private String phone;
    private String password;
    private LocalDateTime createTime;
    private String campus;
    private BigDecimal balance;
    private int is_active;
    private int is_admin;


}
