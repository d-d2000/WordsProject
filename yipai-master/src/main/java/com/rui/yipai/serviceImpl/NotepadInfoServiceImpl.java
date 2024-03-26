package com.rui.yipai.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rui.yipai.entity.NotepadInfo;
import com.rui.yipai.entity.WordsInfo;
import com.rui.yipai.mapper.NotepadInfoMapper;
import com.rui.yipai.service.NotepadInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
@Service
public class NotepadInfoServiceImpl extends ServiceImpl<NotepadInfoMapper, NotepadInfo> implements NotepadInfoService {


    @Autowired
    NotepadInfoMapper notepadInfoMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public HashMap<String, Object> addNotepad(NotepadInfo notepadInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int oid = (Integer)request.getSession().getAttribute("oid");
        notepadInfo.setUserInfoOid(oid);
        notepadInfo.setCreateTime("" + Calendar.getInstance().get(Calendar.YEAR));
        notepadInfoMapper.insert(notepadInfo);
        hashMap.put("success",true);
        hashMap.put("msg","创建成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> deleteNotepad(NotepadInfo notepadInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        notepadInfoMapper.deleteById(notepadInfo.getNotepadOid());
        hashMap.put("success",true);
        hashMap.put("msg","删除成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> updateNotepad(NotepadInfo notepadInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        notepadInfoMapper.updateById(notepadInfo);
        hashMap.put("success",true);
        hashMap.put("msg","修改成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> getNotepad(int start, int limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Page<NotepadInfo> notepadInfoPage = new Page<>();
        notepadInfoPage.setCurrent(start);
        notepadInfoPage.setSize(limit);

        QueryWrapper<NotepadInfo> queryWrapper = new QueryWrapper<>();

        Page<NotepadInfo> notepadInfoPage1 = notepadInfoMapper.selectPage(notepadInfoPage, queryWrapper);
        hashMap.put("success",true);
        hashMap.put("msg","修改成功！");
        hashMap.put("data",notepadInfoPage1);
        return hashMap;
    }
}
