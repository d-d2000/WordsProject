package com.rui.yipai.controller;

import com.rui.yipai.entity.NotepadInfo;
import com.rui.yipai.entity.WordsInfo;
import com.rui.yipai.service.NotepadInfoService;
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
@RequestMapping("/yipai/notepadInfo")
public class NotepadInfoController {
    @Autowired
    NotepadInfoService notepadInfoService;

    @RequestMapping("/add")
    public HashMap<String,Object> addNotepad(NotepadInfo notepadInfo) {
        return notepadInfoService.addNotepad(notepadInfo);
    }

    @RequestMapping("/delete")
    public HashMap<String,Object> deleteNotepad(NotepadInfo notepadInfo) {
        return notepadInfoService.deleteNotepad(notepadInfo);
    }

    @RequestMapping("/update")
    public HashMap<String,Object> updateNotepad(NotepadInfo notepadInfo) {
        return notepadInfoService.updateNotepad(notepadInfo);
    }

    @RequestMapping("/getNotepad")
    public HashMap<String,Object> getNotepad(int start,int limit) {
        return notepadInfoService.getNotepad(start,limit);
    }
}
