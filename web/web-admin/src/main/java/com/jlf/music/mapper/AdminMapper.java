package com.jlf.music.mapper;

import com.jlf.music.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jlf.music.vo.admin.AdminLoginRequestVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * BaseMapper实现了简单的crud方法
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin>{

    int login(AdminLoginRequestVo adminLoginRequestVo);
}
