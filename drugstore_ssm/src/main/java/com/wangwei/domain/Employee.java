package com.wangwei.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工实体类
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id; // 员工id

    private String username; // 用户名

    private String name; // 员工姓名

    private String password; // 密码

    private String phone; // 手机号

    private String sex; // 性别

    private String idNumber; // 身份证号

    private Integer role; // 角色

    private Integer status; // 状态

    private String createTime; // 创建时间

    private String updateTime; // 修改时间

    private Long createUser; // 创建人

    private Long updateUser; // 修改人
}
