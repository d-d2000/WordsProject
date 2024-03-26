package com.rui.yipai.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rui.yipai.entity.HistoryInfo;
import com.rui.yipai.entity.WordsInfo;
import com.rui.yipai.mapper.HistoryInfoMapper;
import com.rui.yipai.service.HistoryInfoService;
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
public class HistoryInfoServiceImpl extends ServiceImpl<HistoryInfoMapper, HistoryInfo> implements HistoryInfoService {

    @Autowired
    HistoryInfoService historyInfoService;

    @Autowired
    HistoryInfoMapper historyInfoMapper;


    @Autowired
    HttpServletRequest request;

    @Override
    public HashMap<String, Object> addHistoryInfo(HistoryInfo historyInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int oid = (Integer)request.getSession().getAttribute("oid");
        historyInfo.setUserInfoOid(oid);
        historyInfo.setCreateTime("" + Calendar.getInstance().get(Calendar.YEAR));
        historyInfoService.save(historyInfo);
        hashMap.put("success",true);
        hashMap.put("msg","创建成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> deleteHistoryInfo(HistoryInfo historyInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        historyInfoMapper.deleteById(historyInfo.getHistoryOid());
        hashMap.put("success",true);
        hashMap.put("msg","删除成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> updateHistoryInfo(HistoryInfo historyInfo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        historyInfoMapper.updateById(historyInfo);
        hashMap.put("success",true);
        hashMap.put("msg","修改成功！");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> getHistoryInfo(int start, int limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Page<HistoryInfo> historyInfoPage = new Page<>();
        historyInfoPage.setCurrent(start);
        historyInfoPage.setSize(limit);

        QueryWrapper<HistoryInfo> queryWrapper = new QueryWrapper<>();

        Page<HistoryInfo> historyInfoPage1 = historyInfoMapper.selectPage(historyInfoPage, queryWrapper);
        hashMap.put("success",true);
        hashMap.put("msg","修改成功！");
        hashMap.put("data",historyInfoPage1);
        return hashMap;
    }
}
