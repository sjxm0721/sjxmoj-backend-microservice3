package com.sjxm.sjxmojbackendjudgeservice.judge.codesandbox;


import com.sjxm.sjxmojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.sjxm.sjxmojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
