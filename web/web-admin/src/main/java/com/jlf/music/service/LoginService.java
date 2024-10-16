package com.jlf.music.service;

import com.jlf.music.vo.login.CaptchaVo;
import com.jlf.music.vo.login.LoginVo;
import com.jlf.music.vo.login.SystemUserInfoVo;

public interface LoginService {
    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfoById(Long userId);

}
