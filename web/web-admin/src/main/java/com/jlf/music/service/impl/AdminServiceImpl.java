package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.Admin;
import com.jlf.music.mapper.AdminMapper;
import com.jlf.music.service.AdminService;
import com.jlf.music.vo.admin.AdminLoginRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int login(AdminLoginRequestVo adminLoginRequestVo) {
        return adminMapper.login(adminLoginRequestVo);
    }
}
