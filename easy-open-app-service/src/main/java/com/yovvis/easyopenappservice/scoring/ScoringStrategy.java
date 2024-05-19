package com.yovvis.easyopenappservice.scoring;

import com.yovvis.easyopenmodel.entity.App;
import com.yovvis.easyopenmodel.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 *
 * @author yovvis
 */
public interface ScoringStrategy {

    /**
     * 执行评分
     *
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;
}