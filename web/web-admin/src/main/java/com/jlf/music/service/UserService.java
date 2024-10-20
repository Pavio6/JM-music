package com.jlf.music.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.User;
import com.jlf.music.vo.user.UserListVo;
import com.jlf.music.vo.user.UserRegistrationVo;


public interface UserService extends IService<User> {
     /**
      *
      * @param currentPage  页码
      * @param pageSize 数据条数
      * @return 分页后的用户列表
      */
     IPage<UserListVo> getUsersByPage(int currentPage, int pageSize);

    void userRegister(UserRegistrationVo userRegistrationVo);

    boolean checkUsername(String username);

    String checkEmail(String email);
}
