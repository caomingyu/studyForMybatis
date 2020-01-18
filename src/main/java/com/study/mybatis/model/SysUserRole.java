package com.study.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CaoMy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRole {

    private Long userId;
    private Long roleId;
}
