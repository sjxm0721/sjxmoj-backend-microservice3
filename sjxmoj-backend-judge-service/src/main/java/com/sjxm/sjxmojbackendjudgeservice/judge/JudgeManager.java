package com.sjxm.sjxmojbackendjudgeservice.judge;


import com.sjxm.sjxmojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.sjxm.sjxmojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.sjxm.sjxmojbackendjudgeservice.judge.strategy.JudgeContext;
import com.sjxm.sjxmojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.sjxm.sjxmojbackendmodel.model.codesandbox.JudgeInfo;
import com.sjxm.sjxmojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理 简化调用
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    public JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if("java".equals(language)){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
