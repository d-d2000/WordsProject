package com.rui.yipai.mapper;

import com.rui.yipai.entity.Condition;
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

    @Select("select count(new_words) as c1,words_state as state from words_info where 1 = 1 group by words_state")
    List<Condition> selectStateWords();

    @Select("SELECT COUNT(new_words) as c2,create_time as createTime FROM words_info WHERE MONTH(create_time) = MONTH(CURRENT_DATE()) AND YEAR(create_time) = YEAR(CURRENT_DATE()) GROUP BY create_time")
    List<Condition> selectTimeWords();
}
