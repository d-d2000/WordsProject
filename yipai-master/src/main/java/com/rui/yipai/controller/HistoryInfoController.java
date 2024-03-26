package com.rui.yipai.controller;

import com.rui.yipai.entity.HistoryInfo;
import com.rui.yipai.entity.NotepadInfo;
import com.rui.yipai.service.HistoryInfoService;
import com.rui.yipai.service.NotepadInfoService;
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
@RequestMapping("/yipai/historyInfo")
public class HistoryInfoController {
    @Autowired
    HistoryInfoService historyInfoService;

    @RequestMapping("/add")
    public HashMap<String,Object> addNotepad(HistoryInfo historyInfo) {
        return historyInfoService.addHistoryInfo(historyInfo);
    }

    @RequestMapping("/delete")
    public HashMap<String,Object> deleteNotepad(HistoryInfo historyInfo) {
        return historyInfoService.deleteHistoryInfo(historyInfo);
    }

    @RequestMapping("/update")
    public HashMap<String,Object> updateNotepad(HistoryInfo historyInfo) {
        return historyInfoService.updateHistoryInfo(historyInfo);
    }

    @RequestMapping("/getNotepad")
    public HashMap<String,Object> getNotepad(int start,int limit) {
        return historyInfoService.getHistoryInfo(start,limit);
    }
}
