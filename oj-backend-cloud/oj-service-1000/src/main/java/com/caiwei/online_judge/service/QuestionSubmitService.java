package com.caiwei.online_judge.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caiwei.online_judge.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.caiwei.online_judge.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.caiwei.online_judge.model.entity.QuestionSubmit;
import com.caiwei.online_judge.model.entity.User;
import com.caiwei.online_judge.model.vo.QuestionSubmitVO;

/**
 * @author caiwei
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2024-05-29 22:55:41
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);


    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
