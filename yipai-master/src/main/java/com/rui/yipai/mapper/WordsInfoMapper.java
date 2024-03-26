package com.rui.yipai.mapper;

import com.rui.yipai.entity.WordsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface WordsInfoMapper extends BaseMapper<WordsInfo> {

    @Select("SELECT * FROM words_info ORDER BY RAND() LIMIT 20")
    List<WordsInfo> selectRandomWords();
}
