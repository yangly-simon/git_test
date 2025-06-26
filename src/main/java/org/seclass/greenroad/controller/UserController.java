package org.seclass.greenroad.controller;

import lombok.extern.slf4j.Slf4j;
import org.seclass.greenroad.dto.LoginFormDTO;
import org.seclass.greenroad.dto.RegisterFormDTO;
import org.seclass.greenroad.dto.Result;
import org.seclass.greenroad.entity.Student;
import org.seclass.greenroad.entity.User;
import org.seclass.greenroad.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 注册功能
     * @param registerForm 注册参数
     *
     */
    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody RegisterFormDTO registerForm){
        return userService.register(registerForm);
    }

    /**
     * 登录功能
     * @param loginForm 登录参数，包含手机号、验证码；或者手机号、密码
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody LoginFormDTO loginForm){
        return userService.login(loginForm);
    }

    @ResponseBody
    @PostMapping("/update")
    public Result updateStudentInfo(@RequestBody Student student){
        return userService.updateStudentInfo(student);
    }




    ///////////////////////////////////////////////////////////////
    @ResponseBody
    @GetMapping("/info")
    public Result getInfo(@RequestParam("phone") String phone){
        return userService.getUserInfo(phone);
    }

//    @ResponseBody
//    @PostMapping("/update")
//    public Result update(@RequestBody User user){
//        return userService.updateUser(user);
//    }

    // 处理支付请求
    @ResponseBody
    @GetMapping("/pay")
    public Result processPayment(@RequestParam int userId,@RequestParam int bookId, @RequestParam double amount) {
        return userService.deductBalance(userId,amount);
    }


    @ResponseBody
    @GetMapping("/getUserInfoByUserId")
    public Result getUserInfoByUserId(@RequestParam("userId") int userId){
        return userService.getUserInfoByUserId(userId);
    }

    // 处理支付请求
    @ResponseBody
    @GetMapping("/getUserParse")
    public Result getUserParse(@RequestParam int userId) {
        return userService.getUserParse(userId);
    }

    @ResponseBody
    @GetMapping("/up")
    public Result up(@RequestParam int userId,@RequestParam double amount) {
        System.out.println("接收到的参数: " + userId+amount);
        return userService.up(userId,amount);
    }

    @ResponseBody
    @GetMapping("/logOff")
    public Result logoff(@RequestParam String phone,@RequestParam String password) {
        return userService.logOff(phone,password);
    }

    @ResponseBody
    @GetMapping("/search")
    public Result search(@RequestParam String key) {
        return userService.search(key);
    }

    @ResponseBody
    @GetMapping("/banUser")
    public Result banUser(@RequestParam int userId) {
        return userService.banUser(userId);
    }

    @ResponseBody
    @GetMapping("/unBanUser")
    public Result search(@RequestParam int userId) {
        return userService.unBanUser(userId);
    }

    @ResponseBody
    @GetMapping("/deleteUserById")
    public Result deleteUserById(@RequestParam int userId) {
        return userService.deleteUser(userId);
    }
}
