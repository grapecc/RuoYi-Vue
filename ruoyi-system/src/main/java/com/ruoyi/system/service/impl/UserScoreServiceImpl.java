package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserScoreMapper;
import com.ruoyi.system.domain.UserScore;
import com.ruoyi.system.service.IUserScoreService;

/**
 * 积分详情图Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
@Service
public class UserScoreServiceImpl implements IUserScoreService 
{
    @Autowired
    private UserScoreMapper userScoreMapper;

    /**
     * 查询积分详情图
     * 
     * @param userId 积分详情图主键
     * @return 积分详情图
     */
    @Override
    public UserScore selectUserScoreByUserId(Long userId)
    {
        return userScoreMapper.selectUserScoreByUserId(userId);
    }

    /**
     * 查询积分详情图列表
     * 
     * @param userScore 积分详情图
     * @return 积分详情图
     */
    @Override
    public List<UserScore> selectUserScoreList(UserScore userScore)
    {
        return userScoreMapper.selectUserScoreList(userScore);
    }

    /**
     * 新增积分详情图
     * 
     * @param userScore 积分详情图
     * @return 结果
     */
    @Override
    public int insertUserScore(UserScore userScore)
    {
        return userScoreMapper.insertUserScore(userScore);
    }

    /**
     * 修改积分详情图
     * 
     * @param userScore 积分详情图
     * @return 结果
     */
    @Override
    public int updateUserScore(UserScore userScore)
    {
        return userScoreMapper.updateUserScore(userScore);
    }

    /**
     * 批量删除积分详情图
     * 
     * @param userIds 需要删除的积分详情图主键
     * @return 结果
     */
    @Override
    public int deleteUserScoreByUserIds(Long[] userIds)
    {
        return userScoreMapper.deleteUserScoreByUserIds(userIds);
    }

    /**
     * 删除积分详情图信息
     * 
     * @param userId 积分详情图主键
     * @return 结果
     */
    @Override
    public int deleteUserScoreByUserId(Long userId)
    {
        return userScoreMapper.deleteUserScoreByUserId(userId);
    }
}
