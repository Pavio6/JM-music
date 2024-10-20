package com.jlf.music.vo.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jlf.music.enums.BaseIsActive;
import com.jlf.music.enums.BaseIsDeleted;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
@Schema(description = "分页查询UserListVo")
@Data
public class UserListVo {

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    @TableField("create_time")
    // 局部处理反序列化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 活跃状态
     */
    @TableField("is_active")
    private BaseIsActive isActive;
    /**
     * 删除
     */
    @TableField("is_deleted")
    private BaseIsDeleted isDeleted;
}
