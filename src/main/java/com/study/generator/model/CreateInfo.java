package com.study.generator.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cao.mingyu
 * 抽取create人id和时间
 */
public class CreateInfo implements Serializable {
    @Override
    public String toString() {
        return "CreateInfo{" +
                "createBy=" + createBy +
                ", createTime=" + createTime +
                '}';
    }

    private static final long serialVersionUID = -3835374476205912206L;
    private Long createBy;
    private Date createTime;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
