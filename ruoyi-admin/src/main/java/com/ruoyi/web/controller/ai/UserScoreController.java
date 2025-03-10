package com.ruoyi.web.controller.ai;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.ResultDto;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sun.jna.platform.win32.OaIdl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UserScore;
import com.ruoyi.system.service.IUserScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分详情图Controller
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
@RestController
@RequestMapping("/ai/score")
public class UserScoreController extends BaseController
{
    @Autowired
    private IUserScoreService userScoreService;

    /**
     * 查询积分详情图列表
     */
    @GetMapping("/list")
    public TableDataInfo list(UserScore userScore)
    {
        startPage();
        List<UserScore> list = userScoreService.selectUserScoreList(userScore);
        return getDataTable(list);
    }

    @PostMapping("/getUserScore")
    public String getUserScore(UserScore userScore){
        List<UserScore> list = userScoreService.selectUserScoreList(userScore);
        Map<String, List<UserScore>> listMap = list.stream().collect(Collectors.groupingBy(UserScore::getAddFlag));
        BigDecimal addSum= new BigDecimal("0.00");
        BigDecimal subSum= new BigDecimal("0.00");
        for (Map.Entry<String, List<UserScore>> stringListEntry : listMap.entrySet()) {
            List<UserScore> scores = stringListEntry.getValue();
            if (stringListEntry.getKey().equals("0")){ //减
                for (UserScore score : scores) {
                    subSum = subSum.add(new BigDecimal(score.getScore()));
                }
            }else { //新增
                for (UserScore score : scores) {
                    addSum = addSum.add(new BigDecimal(score.getScore()));
                }
            }

        }
        BigDecimal subtract = addSum.subtract(subSum);
        String score = subtract.toString();
        return score;
    }


    @GetMapping("/queryList")
    public ResultDto queryList(UserScore userScore)
    {
        startPage();
        List<UserScore> list = userScoreService.selectUserScoreList(userScore);

        ResultDto resultDto = new ResultDto();
        TableDataInfo dataTable = getDataTable(list);
        resultDto.setTableDataInfo(dataTable);
        LoginUser loginUser = SecurityUtils.getLoginUser();
        resultDto.setTotal(loginUser.getUser().getUserName());//用户积分
        return resultDto;
    }

    /**
     * 导出积分详情图列表
     */
    @Log(title = "积分详情图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserScore userScore)
    {
        List<UserScore> list = userScoreService.selectUserScoreList(userScore);
        ExcelUtil<UserScore> util = new ExcelUtil<UserScore>(UserScore.class);
        util.exportExcel(response, list, "积分详情图数据");
    }

    /**
     * 获取积分详情图详细信息
     */
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(userScoreService.selectUserScoreByUserId(userId));
    }

    /**
     * 新增积分详情图
     */
    @Log(title = "积分详情图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserScore userScore)
    {
        return toAjax(userScoreService.insertUserScore(userScore));
    }

    /**
     * 修改积分详情图
     */
    @Log(title = "积分详情图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserScore userScore)
    {
        return toAjax(userScoreService.updateUserScore(userScore));
    }

    /**
     * 删除积分详情图
     */
    @Log(title = "积分详情图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(userScoreService.deleteUserScoreByUserIds(userIds));
    }
}
