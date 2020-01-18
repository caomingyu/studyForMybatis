package com.study.mybatis.mapper;

import com.study.mybatis.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CaoMy
 */
public interface UserMapper {

    SysUser selectById(Long id);

    List<SysUser> selectAll();

    Long insert(SysUser sysUser);

    List<SysUser> selectByParam(@Param("userName") String userName, @Param("userEmail") String userEmail);

    List<SysUser> selectByIdOrUserName(SysUser sysUser);

    List<SysUser> selectByIds(List<Long> ids);
}
