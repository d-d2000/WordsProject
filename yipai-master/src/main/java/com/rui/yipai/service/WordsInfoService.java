package com.rui.yipai.service;

import com.rui.yipai.entity.WordsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
public interface WordsInfoService extends IService<WordsInfo> {
    public HashMap<String, Object> addWords(WordsInfo wordsInfo);

    public HashMap<String, Object> deleteWords(WordsInfo wordsInfo);

    public HashMap<String, Object> updateWords(WordsInfo wordsInfo);

    public HashMap<String, Object> getWords(int start,int limit);
}
