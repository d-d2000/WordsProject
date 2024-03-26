package com.rui.yipai.service;

import com.rui.yipai.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
public interface UserInfoService extends IService<UserInfo> {

    public UserInfo userLogin(String userName,String pwd);

    public HashMap<String,Object> register(String userName, String pwd);

    public HashMap<String,Object> updateUser(UserInfo userInfo);

}
