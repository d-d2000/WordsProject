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
@TableName("history_info")
@ApiModel(value = "HistoryInfo对象", description = "")
public class HistoryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("history_oid")
    private Integer historyOid;

    @TableField("history_word")
    private String historyWord;

    @TableField("history_mean")
    private String historyMean;

    @TableField("create_time")
    private String createTime;

    @TableField("user_info_oid")
    private Integer userInfoOid;


}
