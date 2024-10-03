package com.jlf.music.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.User;
import com.jlf.music.service.UserService;
import com.jlf.music.vo.user.UserListVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

}
