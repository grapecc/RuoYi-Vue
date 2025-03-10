package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UserScore;

/**
 * 积分详情图Service接口
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
public interface IUserScoreService 
{
    /**
     * 查询积分详情图
     * 
     * @param userId 积分详情图主键
     * @return 积分详情图
     */
    public UserScore selectUserScoreByUserId(Long userId);

    /**
     * 查询积分详情图列表
     * 
     * @param userScore 积分详情图
     * @return 积分详情图集合
     */
    public List<UserScore> selectUserScoreList(UserScore userScore);

    /**
     * 新增积分详情图
     * 
     * @param userScore 积分详情图
     * @return 结果
     */
    public int insertUserScore(UserScore userScore);

    /**
     * 修改积分详情图
     * 
     * @param userScore 积分详情图
     * @return 结果
     */
    public int updateUserScore(UserScore userScore);

    /**
     * 批量删除积分详情图
     * 
     * @param userIds 需要删除的积分详情图主键集合
     * @return 结果
     */
    public int deleteUserScoreByUserIds(Long[] userIds);

    /**
     * 删除积分详情图信息
     * 
     * @param userId 积分详情图主键
     * @return 结果
     */
    public int deleteUserScoreByUserId(Long userId);
}
