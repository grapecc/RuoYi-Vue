package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户历史操作记录图对象 opt_history
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
public class OptHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 主键 */
    private Long id;

    /** 原图 */
    @Excel(name = "原图")
    private String realUrl;

    /** 物料图 */
    @Excel(name = "物料图")
    private String matUrl;

    /** 合成合集 */
    @Excel(name = "合成合集")
    private String mkUrl;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRealUrl(String realUrl) 
    {
        this.realUrl = realUrl;
    }

    public String getRealUrl() 
    {
        return realUrl;
    }
    public void setMatUrl(String matUrl) 
    {
        this.matUrl = matUrl;
    }

    public String getMatUrl() 
    {
        return matUrl;
    }
    public void setMkUrl(String mkUrl) 
    {
        this.mkUrl = mkUrl;
    }

    public String getMkUrl() 
    {
        return mkUrl;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("id", getId())
            .append("realUrl", getRealUrl())
            .append("matUrl", getMatUrl())
            .append("mkUrl", getMkUrl())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .toString();
    }
}
