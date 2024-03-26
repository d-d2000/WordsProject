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
@TableName("notepad_info")
@ApiModel(value = "NotepadInfo对象", description = "")
public class NotepadInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("notepad_oid")
    private Integer notepadOid;

    @TableField("notepad_info")
    private String notepadInfo;

    @TableField("create_time")
    private String createTime;

    @TableField("user_info_oid")
    private Integer userInfoOid;


}
