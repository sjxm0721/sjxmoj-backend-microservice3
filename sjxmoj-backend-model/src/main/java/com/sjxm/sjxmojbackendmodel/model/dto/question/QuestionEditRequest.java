package com.sjxm.sjxmojbackendmodel.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 编辑请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class QuestionEditRequest implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 题目标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;
    /**
     * JSON用例
     */
    private List<JudgeCase> judgeCase;

    /**
     * JSON配置
     */
    private JudgeConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}