package com.study.generator.model;

import java.io.Serializable;
import java.util.List;

/**
 * Database Table Remarks:
 * 角色表
 * <p>
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_role
 */
public class SysRole implements Serializable {

    private static final long serialVersionUID = 6350703650462355578L;
    /**
     * Database Column Remarks:
     * 角色ID
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     * 角色名
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role_name
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     * Database Column Remarks:
     * 有效标识
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.enabled
     *
     * @mbg.generated
     */
//    private Integer enabled;
    private Enabled enabled;
    /**
     * Database Column Remarks:
     *   创建人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.create_by
     *
     * @mbg.generated
     */
//    private Long createBy;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.create_time
     *
     * @mbg.generated
     */
//    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.id
     *
     * @return the value of sys_role.id
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.id
     *
     * @param id the value for sys_role.id
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role_name
     *
     * @return the value of sys_role.role_name
     * @mbg.generated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role_name
     *
     * @param roleName the value for sys_role.role_name
     * @mbg.generated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.enabled
     *
     * @return the value of sys_role.enabled
     *
     * @mbg.generated
     */
//    public Integer getEnabled() {
//        return enabled;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.enabled
     *
     * @param enabled the value for sys_role.enabled
     *
     * @mbg.generated
     */
//    public void setEnabled(Integer enabled) {
//        this.enabled = enabled;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_by
     *
     * @return the value of sys_role.create_by
     *
     * @mbg.generated
     */
//    public Long getCreateBy() {
//        return createBy;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_by
     *
     * @param createBy the value for sys_role.create_by
     *
     * @mbg.generated
     */
//    public void setCreateBy(Long createBy) {
//        this.createBy = createBy;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_time
     *
     * @return the value of sys_role.create_time
     *
     * @mbg.generated
     */
//    public Date getCreateTime() {
//        return createTime;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_time
     *
     * @param createTime the value for sys_role.create_time
     * @mbg.generated
     */
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }

    private List<SysPrivilege> sysPrivilegeList;

    public List<SysPrivilege> getSysPrivilegeList() {
        return sysPrivilegeList;
    }

    public void setSysPrivilegeList(List<SysPrivilege> sysPrivilegeList) {
        this.sysPrivilegeList = sysPrivilegeList;
    }

    private CreateInfo createInfo;

    public CreateInfo getCreateInfo() {
        return createInfo;
    }

    public void setCreateInfo(CreateInfo createInfo) {
        this.createInfo = createInfo;
    }

    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enabled=" + enabled +
                ", sysPrivilegeList=" + sysPrivilegeList +
                ", createInfo=" + createInfo +
                '}';
    }
}