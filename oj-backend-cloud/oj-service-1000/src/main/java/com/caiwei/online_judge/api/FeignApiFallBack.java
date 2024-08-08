package com.caiwei.online_judge.api;

import com.caiwei.online_judge.judge.codeSandBox.model.ExecuteCodeRequest;
import com.caiwei.online_judge.judge.codeSandBox.model.ExecuteCodeResponse;
import com.caiwei.online_judge.model.dto.questionSubmit.JudgeInfo;
import org.springframework.stereotype.Component;

@Component
public class FeignApiFallBack implements FeignApi {
    @Override
    public String healthCheck() {
        return "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o";
    }

    @Override
    public ExecuteCodeResponse judge(ExecuteCodeRequest executeCodeRequest) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(null);
        executeCodeResponse.setMessage("代码沙箱宕机,FallBack服务降级o(╥﹏╥)o");
        executeCodeResponse.setStatus(null);
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage("SYSTEM_ERROR");
        judgeInfo.setMemory(null);
        judgeInfo.setTime(null);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
