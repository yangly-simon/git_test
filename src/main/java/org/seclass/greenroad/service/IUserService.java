package org.seclass.greenroad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.seclass.greenroad.dto.LoginFormDTO;
import org.seclass.greenroad.dto.RegisterFormDTO;
import org.seclass.greenroad.dto.Result;
import org.seclass.greenroad.entity.Student;
import org.seclass.greenroad.entity.User;

public interface IUserService extends IService<User> {
//    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm);

    Result register(RegisterFormDTO registerForm);

    Result updateStudentInfo(Student student);

    Result passwordRetrieve(String phone,String user);

    Result passwordReset(String password,String idNum);



    ////////////////////////////////////////////////
    Result getUserInfo(String phone);

    Result updateUser(User user);

    Result deductBalance(int userId,double amount);

    Result getUserInfoByUserId(int userId);

    Result getUserParse(int userId);

    Result up(int userId, double amount);

    Result logOff(String phone,String password);

    Result search(String key);

    Result banUser(int userId);

    Result unBanUser(int userId);

    Result deleteUser(int userId);

}
