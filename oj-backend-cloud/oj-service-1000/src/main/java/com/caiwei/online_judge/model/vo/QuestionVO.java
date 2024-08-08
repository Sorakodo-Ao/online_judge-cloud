package com.caiwei.online_judge.model.vo;

import cn.hutool.json.JSONUtil;
import com.caiwei.online_judge.model.dto.question.JudgeConfig;
import com.caiwei.online_judge.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目
 */
@Data
public class QuestionVO implements Serializable {
    /**
     * id
     */

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 提交数
     */
    private Integer submitNum;

    /**
     * 通过数
     */
    private Integer acceptNum;

    /**
     * 判题配置(json对象)
     */
    private JudgeConfig judgeConfig;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建题目人的信息
     */
    private UserVO userVO;

    private static final long serialVersionUID = 1L;

    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tags = questionVO.getTags();
        if (tags != null) {
            question.setTags(JSONUtil.toJsonStr(tags));
        }
        JudgeConfig judgeConfig = questionVO.getJudgeConfig();
        if (judgeConfig != null) {
            question.setJudgeConfig(JSONUtil.toJsonStr(judgeConfig));
        }
        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        //把Question里的tags String-> QuestionVO 里的 list<String>
        String tagList = question.getTags();
        List<String> tags = JSONUtil.toList(tagList, String.class);
        questionVO.setTags(tags);
        //把Question里的judgeConfig String-> QuestionVO 里的 JudgeConfig 对象
        String judgeConfig = question.getJudgeConfig();
        JudgeConfig judgeConfigBean = JSONUtil.toBean(judgeConfig, JudgeConfig.class);
        questionVO.setJudgeConfig(judgeConfigBean);
        return questionVO;
    }
}