package com.sjxm.sjxmojbackendjudgeservice.judge.codesandbox.impl;


import com.sjxm.sjxmojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.sjxm.sjxmojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.sjxm.sjxmojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.sjxm.sjxmojbackendmodel.model.codesandbox.JudgeInfo;
import com.sjxm.sjxmojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.sjxm.sjxmojbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱（跑业务流程用）
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {

        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }
}
