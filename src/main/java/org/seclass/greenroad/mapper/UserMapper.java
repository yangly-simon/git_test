package org.seclass.greenroad.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.seclass.greenroad.dto.RegisterFormDTO;
import org.seclass.greenroad.entity.Academy;
import org.seclass.greenroad.entity.College;
import org.seclass.greenroad.entity.Student;
import org.seclass.greenroad.entity.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 检查手机号是否已存在
    @Select("SELECT COUNT(*) FROM greenroad_demo.student WHERE phone = #{phone}")
    int existsByPhone(@Param("phone") String phone);

    // 自定义方法，插入用户
    @Insert("INSERT INTO student " +
            "(name, id_num, phone, password, grade, clazz, college_id, academy_id,counselor_id, is_deleted, create_time, update_time) " +
            "VALUES (#{name}, #{idNum}, #{phone}, #{password}, #{grade}, #{clazz}, #{collegeId}, #{academyId},#{counselorId}, 0, NOW(), NOW())")
    boolean registerUser(RegisterFormDTO registerFormDTO);

    // 根据学生号查询用户
    @Select("SELECT * FROM greenroad_demo.student WHERE id_num = #{user}")
    Student findStuByIdNUm(String user);

    // 根据账号查询
    @Select("SELECT * FROM greenroad_demo.academy WHERE user = #{user}")
    Academy findAcademyByUser(String user);
    // 根据账号查询
    @Select("SELECT * FROM greenroad_demo.college WHERE user = #{user}")
    College findCollegeByUser(String user);

    @Update("UPDATE student SET name=#{name}, age=#{age}, grade=#{grade}, pro=#{pro}," +
            "phone=#{phone},password=#{password},DaiKuan=#{daiKuan} WHERE id=#{id}")
    int updateStudentInfo(Student student);

    ////////////////////////////////////////////////////////////////////////
    // 根据手机号查询用户
    @Select("SELECT * FROM greenroad_demo.users WHERE phone = #{phone}")
    User findByPhone(String phone);

    // 根据 phone 查询用户信息
    @Select("SELECT * FROM greenroad_demo.users WHERE phone = #{phone}")
    User selectByPhone(String phone);

    // 根据 phone 查询用户信息
    @Select("SELECT * FROM greenroad_demo.users WHERE id = #{userId}")
    User getUserInfoByUserId(int userId);

    @Update("UPDATE greenroad_demo.users SET phone = #{phone}, campus = #{campus}, email = #{email}, name = #{name},password=#{password} WHERE phone = #{phone}")
    int updateUser(User user);  // 返回影响的行数

    // 更新用户状态（注销）
    @Delete("DELETE FROM greenroad_demo.users WHERE phone = #{phone}")
    int logOff(String phone,String password);

    // 封禁用户状态（封禁）
    @Update("UPDATE greenroad_demo.users SET is_active = 0 WHERE id = #{userId}")
    int banUser(int userId);

    // 恢复用户状态（激活）
    @Update("UPDATE greenroad_demo.users SET is_active = 1 WHERE id = #{userId}")
    int unBanUser(int userId);

    @Select("""
        SELECT *
        FROM greenroad_demo.users
        WHERE (users.name LIKE CONCAT('%', #{key}, '%')
            OR users.email LIKE CONCAT('%', #{key}, '%')
            OR users.phone LIKE CONCAT('%', #{key}, '%')
            OR users.campus LIKE CONCAT('%', #{key}, '%')
            )
        ORDER BY `created_at` DESC
    """)
    List<User> searchUsers(@Param("key") String key);

    // 根据用户ID删除用户
    @Delete("DELETE FROM greenroad_demo.users WHERE id = #{userId}")
    int deleteUserById(@Param("userId") int userId);
}
