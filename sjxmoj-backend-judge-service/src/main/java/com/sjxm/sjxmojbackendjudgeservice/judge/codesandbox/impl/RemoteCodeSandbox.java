package com.sjxm.sjxmojbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sjxm.sjxmojbackendcommon.exception.BusinessException;
import com.sjxm.sjxmojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.sjxm.sjxmojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.sjxm.sjxmojbackendmodel.model.codesandbox.ExecuteCodeResponse;

import static com.sjxm.sjxmojbackendcommon.common.ErrorCode.API_REQUEST_ERROR;

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteCodeSandbox implements CodeSandbox {

    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {

        System.out.println("远程代码沙箱");
        String url = "http://10.211.55.6:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER,AUTH_REQUEST_SECRET).body(json).execute().body();
        if(StringUtils.isBlank(responseStr)){
            throw new BusinessException(API_REQUEST_ERROR,"executeCode remoteSandbox error,message = "+responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }


}
