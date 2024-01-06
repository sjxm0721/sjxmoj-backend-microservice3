package com.sjxm.sjxmojbackendserviceclient.service;


import com.sjxm.sjxmojbackendmodel.model.entity.Question;
import com.sjxm.sjxmojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
* @author sijixiamu
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-12-15 09:26:42
*/
@FeignClient(name = "sjxmoj-backend-question-service",path = "/api/question/inner")
public interface QuestionFeignClient {

    /**
     * 根据id获取题目信息
     * @param questionId
     * @return
     */
    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    /**
     * 获取题目提交信息
     * @param questionSubmitId
     * @return
     */
    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);

    /**
     * 更新题目提交信息
     * @param questionSubmit
     * @return
     */
    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);

}
