package com.study.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CaoMy
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysPrivilege {

    private Long id;
    private String privilegeName;
    private String privilegeUrl;
}
