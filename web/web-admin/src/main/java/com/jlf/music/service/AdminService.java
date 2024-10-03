package com.jlf.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.Admin;
import com.jlf.music.vo.admin.AdminLoginRequestVo;

public interface AdminService extends IService<Admin> {
    int login(AdminLoginRequestVo adminLoginRequestVo);
}
