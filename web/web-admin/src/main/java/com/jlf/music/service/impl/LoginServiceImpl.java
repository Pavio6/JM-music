package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jlf.music.common.constant.RedisConstant;
import com.jlf.music.common.utils.JwtUtil;
import com.jlf.music.entity.User;
import com.jlf.music.enums.BaseStatus;
import com.jlf.music.mapper.UserMapper;
import com.jlf.music.service.LoginService;
import com.jlf.music.vo.login.CaptchaVo;
import com.jlf.music.vo.login.LoginVo;
import com.jlf.music.vo.login.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;
    @Override
    public CaptchaVo getCaptcha() {
        // 创建一个验证码
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 获取验证码信息 并转为小写
        String code = specCaptcha.text().toLowerCase();
        // 为验证码生成一个key值  用来唯一标识
        String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID();
        // 将 key code值 存放到redis中
        stringRedisTemplate
                .opsForValue()
                .set(key, code, RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS); // 单位为秒
        return new CaptchaVo(specCaptcha.toBase64(), key);
    }

    @Override
    public String login(LoginVo loginVo) {
        // 验证码
        if (loginVo.getCaptchaCode() == null) {
            // TODO 所有异常需要设置自定义异常
            // throw new UserLoginException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
            throw new IllegalArgumentException("验证码未提供");
        }
        // 获取验证码值
        String code = stringRedisTemplate
                .opsForValue()
                .get(loginVo.getCaptchaKey());
        if (code == null) {
            throw new IllegalArgumentException("验证码已过期");
        }
        // 需要将用户输入的验证码转换为小写在和redis中进行比较
        if (!code.equals(loginVo.getCaptchaCode().toLowerCase())) {
            throw new IllegalArgumentException("验证码错误");
        }
        // 获取用户信息 判断该用户是否存在
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, loginVo.getUsername());
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        if (user.getStatus() == BaseStatus.DISABLE) {
            throw new IllegalArgumentException("该用户已被禁用");
        }
        // 判断密码是否正确  数据库中存放的是MD5加密后的密码 所以需要先将用户输入的密码转为MD5加密的再进行比对
        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(loginVo.getPassword().getBytes()))) {
            throw new IllegalArgumentException("用户密码错误");
        }
        // TODO 用户活动状态的改变
        return JwtUtil.createToken(user.getId(), user.getUsername());
    }

    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long userId) {
        User user = userMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setUsername(user.getUsername());
        systemUserInfoVo.setProfilePicture(user.getProfilePicture());
        return systemUserInfoVo;
    }
}
