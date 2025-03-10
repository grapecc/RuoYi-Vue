package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OptHistoryMapper;
import com.ruoyi.system.domain.OptHistory;
import com.ruoyi.system.service.IOptHistoryService;

/**
 * 用户历史操作记录图Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
@Service
public class OptHistoryServiceImpl implements IOptHistoryService 
{
    @Autowired
    private OptHistoryMapper optHistoryMapper;

    /**
     * 查询用户历史操作记录图
     * 
     * @param id 用户历史操作记录图主键
     * @return 用户历史操作记录图
     */
    @Override
    public OptHistory selectOptHistoryById(Long id)
    {
        return optHistoryMapper.selectOptHistoryById(id);
    }

    /**
     * 查询用户历史操作记录图列表
     * 
     * @param optHistory 用户历史操作记录图
     * @return 用户历史操作记录图
     */
    @Override
    public List<OptHistory> selectOptHistoryList(OptHistory optHistory)
    {
        return optHistoryMapper.selectOptHistoryList(optHistory);
    }

    /**
     * 新增用户历史操作记录图
     * 
     * @param optHistory 用户历史操作记录图
     * @return 结果
     */
    @Override
    public int insertOptHistory(OptHistory optHistory)
    {
        optHistory.setCreateTime(DateUtils.getNowDate());
        return optHistoryMapper.insertOptHistory(optHistory);
    }

    /**
     * 修改用户历史操作记录图
     * 
     * @param optHistory 用户历史操作记录图
     * @return 结果
     */
    @Override
    public int updateOptHistory(OptHistory optHistory)
    {
        return optHistoryMapper.updateOptHistory(optHistory);
    }

    /**
     * 批量删除用户历史操作记录图
     * 
     * @param ids 需要删除的用户历史操作记录图主键
     * @return 结果
     */
    @Override
    public int deleteOptHistoryByIds(Long[] ids)
    {
        return optHistoryMapper.deleteOptHistoryByIds(ids);
    }

    /**
     * 删除用户历史操作记录图信息
     * 
     * @param id 用户历史操作记录图主键
     * @return 结果
     */
    @Override
    public int deleteOptHistoryById(Long id)
    {
        return optHistoryMapper.deleteOptHistoryById(id);
    }
}
