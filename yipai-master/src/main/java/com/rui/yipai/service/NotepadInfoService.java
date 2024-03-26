package com.rui.yipai.service;

import com.rui.yipai.entity.NotepadInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rui.yipai.entity.WordsInfo;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
public interface NotepadInfoService extends IService<NotepadInfo> {
    public HashMap<String, Object> addNotepad(NotepadInfo notepadInfo);

    public HashMap<String, Object> deleteNotepad(NotepadInfo notepadInfo);

    public HashMap<String, Object> updateNotepad(NotepadInfo notepadInfo);

    public HashMap<String, Object> getNotepad(int start,int limit);
}
