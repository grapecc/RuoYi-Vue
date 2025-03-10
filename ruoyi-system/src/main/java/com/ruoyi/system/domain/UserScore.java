package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分详情图对象 user_score
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
public class UserScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long userId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateTime;

    /** 积分 */
    @Excel(name = "积分")
    private String score;

    /** 删除-0  新增-1  */
    @Excel(name = "删除-0  新增-1 ")
    private String addFlag;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDateTime(Date dateTime) 
    {
        this.dateTime = dateTime;
    }

    public Date getDateTime() 
    {
        return dateTime;
    }
    public void setScore(String score) 
    {
        this.score = score;
    }

    public String getScore() 
    {
        return score;
    }
    public void setAddFlag(String addFlag) 
    {
        this.addFlag = addFlag;
    }

    public String getAddFlag() 
    {
        return addFlag;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("dateTime", getDateTime())
            .append("score", getScore())
            .append("addFlag", getAddFlag())
            .append("note", getNote())
            .toString();
    }
}
