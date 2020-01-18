package com.study.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CaoMy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRolePrivilege {

    private Long roleId;
    private Long privilegeId;
}
