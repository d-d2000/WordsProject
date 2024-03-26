package com.rui.yipai.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rui.yipai.entity.WordsInfo;
import com.rui.yipai.mapper.WordsInfoMapper;
import com.rui.yipai.service.WordsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
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
public class WordsInfoServiceImpl extends ServiceImpl<WordsInfoMapper, WordsInfo> implements WordsInfoService {


    @Autowired
    WordsInfoMapper wordsInfoMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public HashMap<String, Object> addWords(WordsInfo wordsInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();

        int oid = (Integer)request.getSession().getAttribute("oid");
        wordsInfo.setUserInfoOid(oid);
        Date date = new Date();
        String time = String.format("%tF", date);
        wordsInfo.setCreateTime(time);
        wordsInfoMapper.insert(wordsInfo);

        hashMap.put("success",true);
        hashMap.put("msg","创建成功！");
        hashMap.put("data",wordsInfo);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> deleteWords(WordsInfo wordsInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        wordsInfoMapper.deleteById(wordsInfo.getWordsOid());
        hashMap.put("success",true);
        hashMap.put("msg","删除成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> updateWords(WordsInfo wordsInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        wordsInfoMapper.updateById(wordsInfo);
        hashMap.put("success",true);
        hashMap.put("msg","修改成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> getWords(int start,int limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Page<WordsInfo> wordsInfoPage = new Page<>();
        wordsInfoPage.setCurrent(start);
        wordsInfoPage.setSize(limit);

        QueryWrapper<WordsInfo> queryWrapper = new QueryWrapper<>();
        String userName = (String)request.getSession().getAttribute("userName");
        int oid = (Integer)request.getSession().getAttribute("oid");
        if(!userName.equals("admin")) {
            queryWrapper.eq("user_info_oid",oid);
        }
        Page<WordsInfo> wordsInfoPage1 = wordsInfoMapper.selectPage(wordsInfoPage, queryWrapper);
        hashMap.put("success",true);
        hashMap.put("msg","修改成功！");
        hashMap.put("data",wordsInfoPage1);
        return hashMap;
    }

}
