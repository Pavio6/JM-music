package com.jlf.music.controller.login;


import com.jlf.music.common.login.LoginUserHolder;
import com.jlf.music.common.result.Result;
import com.jlf.music.service.LoginService;
import com.jlf.music.vo.login.CaptchaVo;
import com.jlf.music.vo.login.LoginVo;
import com.jlf.music.vo.login.SystemUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 前台用户登录业务
 */

@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo result = loginService.getCaptcha();
        return Result.ok(result);
    }

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt = loginService.login(loginVo);
        return Result.ok(jwt);
    }
    @Operation(summary = "获取登录用户的个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        SystemUserInfoVo systemUserInfoVo = loginService.getLoginUserInfoById(userId);
        return Result.ok(systemUserInfoVo);
    }
}
