package com.jlf.music.vo.user;

import com.alibaba.fastjson2.function.impl.ToDouble;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
@Schema(description = "分页查询UserListVo")
@Data
public class UserListVo {
    /**
     * 用户ID，主键，自动增长
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电子邮箱
     */
    private String email;
    /**
     * TODO
     *    is_active和is_deleted 返回结果是active deleted
     */
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 活跃状态
     */
    @TableField("is_active")
    private boolean isActive;
    /**
     * 删除
     */
    @TableField("is_deleted")
    private boolean isDeleted;
}
