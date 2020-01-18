package com.study.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author CaoMy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRole {

    private Long id;
    private String roleName;
    private Long enabled;
    private Long createBy;
    private Date createTime;

    private SysUser user;
}
