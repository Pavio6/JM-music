package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.User;
import com.jlf.music.mapper.UserMapper;
import com.jlf.music.service.UserService;
import com.jlf.music.vo.user.UserListVo;
import com.jlf.music.vo.user.UserRegistrationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDate;
import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage<UserListVo> getUsersByPage(int currentPage, int pageSize) {
        Page<UserListVo> page = new Page<>(currentPage, pageSize);
        return userMapper.selectUsersByPage(page);
    }

    @Override
    public void userRegister(UserRegistrationVo userRegistrationVo) {
        LambdaQueryWrapper<User> wrapperEmail = new LambdaQueryWrapper<>();
        wrapperEmail.eq(User::getEmail, userRegistrationVo.getEmail());
        User user = new User();
        // 邮箱格式
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        // 检查username
        if (!this.checkUsername(userRegistrationVo.getUsername())) {
            throw new IllegalArgumentException("用户名已存在");
        }
        if (this.checkEmail(userRegistrationVo.getEmail()).equals("邮箱已被注册")) {
            throw new IllegalArgumentException("邮箱已被注册");
        }
        if (this.checkEmail(userRegistrationVo.getEmail()).equals("邮箱格式不正确")) {
            throw new IllegalArgumentException("邮箱格式不正确");
        }
        // 为密码进行md5加密
        userRegistrationVo.setPassword(DigestUtils.md5DigestAsHex(userRegistrationVo.getPassword().getBytes()));
        BeanUtils.copyProperties(userRegistrationVo, user);
        userMapper.insert(user);
    }

    @Override
    public boolean checkUsername(String username) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, username);
        // == 0 说明数据库中没有当前username 返回true
        return userMapper.selectCount(userLambdaQueryWrapper) == 0;
    }

    @Override
    public String checkEmail(String email) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getEmail, email);
        // 邮箱格式
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (userMapper.selectCount(userLambdaQueryWrapper) > 0) {
            return "邮箱已被注册";
        }
        if (!email.matches(emailRegex)) {
            return "邮箱格式不正确";
        }
        return "邮箱可用";
    }
}
