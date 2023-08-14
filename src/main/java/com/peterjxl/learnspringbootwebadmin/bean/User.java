package com.peterjxl.learnspringbootwebadmin.bean;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String password;

    // 以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
