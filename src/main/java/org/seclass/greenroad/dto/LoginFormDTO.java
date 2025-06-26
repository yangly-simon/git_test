package org.seclass.greenroad.dto;

import lombok.Data;

@Data
public class LoginFormDTO {
    private String user;
    private String password;
    private int type;
}

