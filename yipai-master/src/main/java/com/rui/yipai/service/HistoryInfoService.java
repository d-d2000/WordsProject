package com.rui.yipai.service;

import com.rui.yipai.entity.HistoryInfo;
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
public interface HistoryInfoService extends IService<HistoryInfo> {
    public HashMap<String, Object> addHistoryInfo(HistoryInfo historyInfo);

    public HashMap<String, Object> deleteHistoryInfo(HistoryInfo historyInfo);

    public HashMap<String, Object> updateHistoryInfo(HistoryInfo historyInfo);

    public HashMap<String, Object> getHistoryInfo(int start,int limit);
}
