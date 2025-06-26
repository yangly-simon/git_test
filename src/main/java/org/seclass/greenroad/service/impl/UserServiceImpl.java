package org.seclass.greenroad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.seclass.greenroad.dto.LoginFormDTO;
import org.seclass.greenroad.dto.RegisterFormDTO;
import org.seclass.greenroad.dto.Result;
import org.seclass.greenroad.entity.Academy;
import org.seclass.greenroad.entity.College;
import org.seclass.greenroad.entity.Student;
import org.seclass.greenroad.entity.User;
import org.seclass.greenroad.mapper.UserMapper;
import org.seclass.greenroad.service.IUserService;
import org.springframework.boot.autoconfigure.context.LifecycleProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LifecycleProperties lifecycleProperties;

    @Override
    public Result register(RegisterFormDTO registerFormDTO) {
        // 1. 参数非空校验
        if (registerFormDTO.getPhone() == null || registerFormDTO.getPassword() == null) {
            return Result.fail("手机号或密码不能为空");
        }

        // 2. 检查手机号是否已被注册
        int count = userMapper.existsByPhone(registerFormDTO.getPhone());
        if (count > 0) {
            return Result.fail("该手机号已被注册");
        }

        System.out.println(registerFormDTO);
        // 4. 插入新用户
        boolean flag=userMapper.registerUser(registerFormDTO);

        // 5. 返回注册成功消息
        if (flag) {
            return Result.ok("注册成功");
        }else {
            return Result.fail("注册失败");
        }
    }

    @Override
    public Result login(LoginFormDTO loginFormDTO) {
        if (loginFormDTO.getType() ==1 ){
            Student student= userMapper.findStuByIdNUm(loginFormDTO.getUser());

            if (student==null) return Result.fail("用户不存在");
            else if (loginFormDTO.getPassword().equals(student.getPassword())){
                return Result.ok(student);
            }
            else return Result.fail("密码错误");
        } else if (loginFormDTO.getType() ==2 ) {
            Academy academy=userMapper.findAcademyByUser(loginFormDTO.getUser());
            if (academy==null) return Result.fail("用户不存在");
            else if (loginFormDTO.getPassword().equals(academy.getPassword())){
                return Result.ok(academy);
            }
            else return Result.fail("密码错误");
        } else if (loginFormDTO.getType() ==3 ){
            College college=userMapper.findCollegeByUser(loginFormDTO.getUser());
//            System.out.println("collegepassword:"+college.getPassword());
//            System.out.println("academypassword:"+loginFormDTO.getPassword());

            if (college==null) return Result.fail("用户不存在");
            else if (loginFormDTO.getPassword().equals(college.getPassword())){
                return Result.ok(college);
            }
            else return Result.fail("密码错误");
        }else return Result.fail("type error");
    }

    @Override
    public Result updateStudentInfo(Student updated){
        Student existing = userMapper.findStuByIdNUm(updated.getIdNum());
        if (existing == null) {
            return Result.fail("用户不存在");
        }
        // 仅更新非空字段
        if (updated.getName() != null) existing.setName(updated.getName());
        if (updated.getAge() != null) existing.setAge(updated.getAge());
        if (updated.getGrade() != null) existing.setGrade(updated.getGrade());
        if (updated.getPro() != null) existing.setPro(updated.getPro());

        if (updated.getPhone() != null) existing.setPhone(updated.getPhone());
        if (updated.getPassword() != null) existing.setPassword(updated.getPassword());
        if (updated.getDaiKuan() != null) existing.setDaiKuan(updated.getDaiKuan());
        return Result.ok(userMapper.updateStudentInfo(existing) > 0);




    }


    ////////////////////////////////////////////////////////////////////////

    @Override
    public Result getUserInfo(String phone){
        User user = userMapper.selectByPhone(phone);

        if (user == null) {
            return Result.fail("用户不存在");
        }else {
            return Result.ok(user);
        }
    }

    @Override
    public Result getUserInfoByUserId(int userId){
        User user = userMapper.getUserInfoByUserId(userId);
        if (user == null) {
            return Result.fail("用户不存在");
        }else {
            return Result.ok(user);
        }
    }

    @Override
    public Result updateUser(User user) {
        int rowsAffected = userMapper.updateUser(user);
        if (rowsAffected > 0) {
            return Result.ok(userMapper.selectByPhone(user.getPhone()));
        }else {
            return Result.fail("信息修改失败");
        }
    }

    @Override
    public Result deductBalance(int userId,double amount) {
        // 检查余额
        Double balance = userMapper.getUserBalance(userId);
        if (balance == null || balance < amount) {
            return Result.fail("余额不足");
        }
        // 扣款操作
        int rows = userMapper.deductBalance(userId, amount);
        if (rows == 0) {
            return Result.fail("扣款失败，可能余额不足");
        }
        return Result.ok("付款成功");

    }

    @Override
    public Result getUserParse(int userId) {
        // 检查余额
        Double balance = userMapper.getUserBalance(userId);
        return Result.ok(balance);
    }

    @Override
    public Result up(int userId, double amount) {

        // 检查余额
        int balance = userMapper.up(userId,amount);
        System.out.println("balance" +balance);

        return Result.ok(balance);
    }

    @Override
    public Result logOff(String phone,String password) {
        int flag = userMapper.logOff(phone,password);
        if (flag > 0) {
            return Result.ok("注销成功");
        }else {
            return Result.fail("注销失败");
        }
    }

    @Override
    public Result search(String key) {
        List<User> users= userMapper.searchUsers(key);
        if (users==null || users.isEmpty()) {
            return Result.fail("查询失败");
        }else {
            return Result.ok(users);
        }
    }

    @Override
    public Result banUser(int userId) {
        int flag=userMapper.banUser(userId);
        if (flag<=0) {
            return Result.fail("封禁失败");
        }else {
            return Result.ok("封禁成功");
        }
    }

    @Override
    public Result unBanUser(int userId) {
        int flag=userMapper.unBanUser(userId);
        if (flag<=0) {
            return Result.fail("激活失败");
        }else {
            return Result.ok("激活成功");
        }
    }

    @Override
    public Result deleteUser(int userId) {
        System.out.println(userId);
        int flag=userMapper.deleteUserById(userId);
        if (flag<=0) {
            return Result.fail("删除失败");
        }else {
            return Result.ok("删除成功");
        }
    }

}
