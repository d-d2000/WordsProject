package com.rui.yipai.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
@Getter
@Setter
@TableName("words_info")
@ApiModel(value = "WordsInfo对象", description = "")
public class WordsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("words_oid")
    private Integer wordsOid;

    @TableField("new_words")
    private String newWords;

    @TableField("new_words_mean")
    private String newWordsMean;

    @TableField("words_state")
    private Boolean wordsState;

    @TableField("create_time")
    private String createTime;

    @TableField("user_info_oid")
    private Integer userInfoOid;


}
