package com.jlf.music.service;

import com.jlf.music.vo.login.CaptchaVo;
import com.jlf.music.vo.login.LoginVo;

public interface LoginService {
    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);
}
