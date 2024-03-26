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
@TableName("user_info")
@ApiModel(value = "UserInfo对象", description = "")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_oid")
    private Integer userOid;

    @TableField("user_name")
    private String userName;

    @TableField("user_pwd")
    private String userPwd;

    @TableField("user_state")
    private Boolean userState;

    @TableField("create_time")
    private String createTime;


}
