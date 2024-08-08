package com.caiwei.online_judge.judge.strategy.judgeStrategy;

import cn.hutool.json.JSONUtil;
import com.caiwei.online_judge.judge.strategy.JudgeStrategy;
import com.caiwei.online_judge.judge.strategy.context.JudgeContext;
import com.caiwei.online_judge.model.dto.question.JudgeCase;
import com.caiwei.online_judge.model.dto.question.JudgeConfig;
import com.caiwei.online_judge.model.dto.questionSubmit.JudgeInfo;
import com.caiwei.online_judge.model.entity.Question;
import com.caiwei.online_judge.model.enums.JudgeInfoMessageEnum;

import java.util.List;

public class CppJudgeStrategy implements JudgeStrategy {
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        Question question = judgeContext.getQuestion();
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();


        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPT;

        //题目不需要输入输出用例，只有答案
        String output = outputList.get(0);
        String answer = question.getAnswer();
        if (!output.equals(answer)) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
        }

        //判断题目限制
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        //获得执行后的信息
        String message = judgeInfo.getMessage();
        Integer memory = judgeInfo.getMemory();
        Integer time = judgeInfo.getTime();

        //内存溢出和超时
        if (memory > judgeConfig.getMemoryLimit()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
        }
        if (time > judgeConfig.getTimeLimit()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
        }
        //危险操作
        if ("DANGER".equals(message)) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.DANGEROUS_OPERATION;
        }
        if("SYSTEM_ERROR".equals(message)){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.SYSTEM_ERROR;
        }
        //设置返回的信息
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        judgeInfoResponse.setMemory(judgeInfo.getMemory());
        judgeInfoResponse.setTime(time);

        return judgeInfoResponse;
    }
}
