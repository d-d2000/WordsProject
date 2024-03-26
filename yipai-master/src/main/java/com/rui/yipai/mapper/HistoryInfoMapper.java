package com.rui.yipai.mapper;

import com.rui.yipai.entity.HistoryInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rui.yipai.entity.WordsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
@Mapper
public interface HistoryInfoMapper extends BaseMapper<HistoryInfo> {
}
