package com.caiwei.online_judge.codeSandBox;

import com.caiwei.online_judge.model.ExecuteCodeRequest;
import com.caiwei.online_judge.model.ExecuteCodeResponse;

public interface CodeSandBox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
