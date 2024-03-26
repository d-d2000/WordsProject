package com.rui.yipai.controller;

import com.rui.yipai.entity.WordsInfo;
import com.rui.yipai.service.WordsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
@RestController
@RequestMapping("/yipai/wordsInfo")
public class WordsInfoController {

    @Autowired
    WordsInfoService wordsInfoService;

    @RequestMapping("/add")
    public HashMap<String,Object> addWords(WordsInfo wordsInfo) {
        return wordsInfoService.addWords(wordsInfo);
    }

    @RequestMapping("/delete")
    public HashMap<String,Object> deleteWords(WordsInfo wordsInfo) {
        return wordsInfoService.deleteWords(wordsInfo);
    }

    @RequestMapping("/update")
    public HashMap<String,Object> updateWords(WordsInfo wordsInfo) {
        return wordsInfoService.updateWords(wordsInfo);
    }

    @RequestMapping("/getWords")
    public HashMap<String,Object> getWords(int start,int limit) {
        return wordsInfoService.getWords(start,limit);
    }

}
