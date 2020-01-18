package com.study.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author CaoMy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {

    private Long id;
    private String userName;
    private String userPassword;
    private String userEmial;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;
}
