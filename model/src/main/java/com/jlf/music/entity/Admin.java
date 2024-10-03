package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Schema(description = "管理员表") // 描述信息
@TableName(value = "admin") // 指定数据库表名
// 用于自动生成 equals() 和 hashCode() 方法
// 在类的继承结构中，如果你想要包含父类的字段来计算 equals 和 hashCode，可以使用这个注解
@EqualsAndHashCode(callSuper = true)
public class Admin extends BaseEntity {
    private String name;
    private String password;
}
