package com.jlf.music.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.User;
import com.jlf.music.service.UserService;
import com.jlf.music.vo.user.UserListVo;
import com.jlf.music.vo.user.UserRegistrationVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "后台用户管理")
@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "根据条件分页查询用户信息")
    @GetMapping("pageUser")
    public Result<IPage<UserListVo>> getUsersByPage(
            @RequestParam(defaultValue = "1") int currentPage, // 页码
            @RequestParam(defaultValue = "10") int pageSize) {  // 数据条数
        IPage<UserListVo> result = userService.getUsersByPage(currentPage, pageSize);
        return Result.ok(result);
    }
    @Operation(summary = "根据用户名查询用户信息")
    @GetMapping("getUserByUsername")
    public Result<UserListVo> getUserByUsername(@RequestParam String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = userService.getOne(wrapper);
        // 用于将一个对象的属性值复制到另一个对象中
        UserListVo userListVo = new UserListVo();
        BeanUtils.copyProperties(user, userListVo);
        return Result.ok(userListVo);
    }
    @Operation(summary = "用户名校验")
    @GetMapping("register/check-username")
    public Result checkUsername(@RequestParam String username) {
        boolean available = userService.checkUsername(username);
        String message = available ? "用户名可用" : "用户名已被使用";
        return Result.ok(message);
    }
    @Operation(summary = "邮箱校验")
    @GetMapping("register/check-email")
    public Result checkEmail(@RequestParam String email) {
        String message = userService.checkEmail(email);
        return Result.ok(message);
    }
    @Operation(summary = "用户注册")
    @PostMapping("register")
    public Result userRegister(@RequestBody UserRegistrationVo userRegistrationVo) {
        userService.userRegister(userRegistrationVo);
        return Result.ok();
    }
}
