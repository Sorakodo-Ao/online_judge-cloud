package com.caiwei.online_judge.controller;



import com.caiwei.online_judge.codeSandBox.CodeSandBox;
import com.caiwei.online_judge.codeSandBox.Impl.CppNativeCodeSandbox;
import com.caiwei.online_judge.codeSandBox.Impl.JavaNativeCodeSandBox;
import com.caiwei.online_judge.codeSandBox.Impl.RemoteCodeSandBox;
import com.caiwei.online_judge.model.ExecuteCodeRequest;
import com.caiwei.online_judge.model.ExecuteCodeResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeController {
    @PostMapping("/judge")
    public ExecuteCodeResponse judge(@RequestBody ExecuteCodeRequest executeCodeRequest) {
        System.out.println("executeCodeRequest = " + executeCodeRequest);
        String language = executeCodeRequest.getLanguage();
        CodeSandBox codeSandBox = null;
        //根据language选择对应的判题机
        if(language.equals("java")){
            codeSandBox = new JavaNativeCodeSandBox();
        } else if (language.equals("c") || language.equals("cpp")) {
            codeSandBox = new CppNativeCodeSandbox();
        }else{
            codeSandBox = new RemoteCodeSandBox();
        }
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        return executeCodeResponse;
    }
}
