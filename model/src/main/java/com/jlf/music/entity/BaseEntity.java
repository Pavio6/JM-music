package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TableLogic 查询时自动添加is_deleted = 0 的过滤条件
 * 逻辑删除功能只对Mybatis-Plus自动注入的sql起效，也就是说，
 * 对于手动在`Mapper.xml`文件配置的sql不会生效，需要单独考虑
 */

/**
 * JsonIgnore 注解，会在序列化时忽略添加该注解的字段
 * 也就是说查询的时候 返回的结果不会包含该字段
 */

/**
 * TableField(fill = ...)
 * 为相关字段配置触发填充的时机 例如create_time在插入时填充
 * 还需要 配置自动填充的内容
 * MybatisMetaObjectHandler类 实现MetaObjectHandler接口 中 insertFill和updateFill方法
 */
@Data
public class BaseEntity implements Serializable {

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonIgnore
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @JsonIgnore
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    @JsonIgnore
    @TableLogic
    @Schema(description = "逻辑删除")
    @TableField("is_deleted")
    private Byte isDeleted;

}