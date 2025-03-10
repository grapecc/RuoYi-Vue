package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OptHistory;

/**
 * 用户历史操作记录图Service接口
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
public interface IOptHistoryService 
{
    /**
     * 查询用户历史操作记录图
     * 
     * @param id 用户历史操作记录图主键
     * @return 用户历史操作记录图
     */
    public OptHistory selectOptHistoryById(Long id);

    /**
     * 查询用户历史操作记录图列表
     * 
     * @param optHistory 用户历史操作记录图
     * @return 用户历史操作记录图集合
     */
    public List<OptHistory> selectOptHistoryList(OptHistory optHistory);

    /**
     * 新增用户历史操作记录图
     * 
     * @param optHistory 用户历史操作记录图
     * @return 结果
     */
    public int insertOptHistory(OptHistory optHistory);

    /**
     * 修改用户历史操作记录图
     * 
     * @param optHistory 用户历史操作记录图
     * @return 结果
     */
    public int updateOptHistory(OptHistory optHistory);

    /**
     * 批量删除用户历史操作记录图
     * 
     * @param ids 需要删除的用户历史操作记录图主键集合
     * @return 结果
     */
    public int deleteOptHistoryByIds(Long[] ids);

    /**
     * 删除用户历史操作记录图信息
     * 
     * @param id 用户历史操作记录图主键
     * @return 结果
     */
    public int deleteOptHistoryById(Long id);
}
