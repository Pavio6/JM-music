package com.jlf.music.controller;

import com.jlf.music.common.result.Result;
import com.jlf.music.service.AdminService;
import com.jlf.music.vo.admin.AdminLoginRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "后台登录管理")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    // RequestBody 注解使得后端能够直接接收请求体中的 JSON 数据，并将其转换为指定的 Java 对象
    @PostMapping("login")
    @Operation(summary = "验证登录信息")
    public Result adminLogin(@RequestBody AdminLoginRequestVo adminLoginRequestVo) {

        int result = adminService.login(adminLoginRequestVo);
        if (result == 1) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
