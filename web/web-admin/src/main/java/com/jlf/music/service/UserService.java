package com.jlf.music.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.User;
import com.jlf.music.vo.user.UserListVo;


public interface UserService extends IService<User> {
     /**
      *
      * @param currentPage  页码
      * @param pageSize 数据条数
      * @return 分页后的用户列表
      */
     IPage<UserListVo> getUsersByPage(int currentPage, int pageSize);
}
