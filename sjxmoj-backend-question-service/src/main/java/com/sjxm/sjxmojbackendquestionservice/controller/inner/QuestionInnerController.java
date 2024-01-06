package com.sjxm.sjxmojbackendquestionservice.controller.inner;

import com.sjxm.sjxmojbackendmodel.model.entity.Question;
import com.sjxm.sjxmojbackendmodel.model.entity.QuestionSubmit;
import com.sjxm.sjxmojbackendquestionservice.service.QuestionService;
import com.sjxm.sjxmojbackendquestionservice.service.QuestionSubmitService;
import com.sjxm.sjxmojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: 四季夏目
 * @Date: 2024/1/4
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    /**
     * 根据id获取题目信息
     * @param questionId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("questionId") long questionId){
        return questionService.getById(questionId);
    }

    /**
     * 获取题目提交信息
     * @param questionSubmitId
     * @return
     */
    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }

    /**
     * 更新题目提交信息
     * @param questionSubmit
     * @return
     */
    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit){
        return questionSubmitService.updateById(questionSubmit);
    }
}
