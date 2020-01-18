package com.study.mybatis.mapper;

import com.study.mybatis.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CaoMy
 */
public interface RoleMapper {
    List<SysRole> selectAll();

    Long insert(SysRole sysRole, @Param("my_enable") String enable);
}
