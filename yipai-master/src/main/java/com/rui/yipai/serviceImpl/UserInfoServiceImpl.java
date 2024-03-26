package com.rui.yipai.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rui.yipai.entity.UserInfo;
import com.rui.yipai.exception.WordsException;
import com.rui.yipai.mapper.UserInfoMapper;
import com.rui.yipai.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public UserInfo userLogin(String userName, String pwd) {
        QueryWrapper<UserInfo> userInfoMapperQueryWrapper = new QueryWrapper<>();
        userInfoMapperQueryWrapper.eq("user_name",userName)
                .eq("user_pwd",pwd)
                .eq("user_state",1);
        List<UserInfo> userInfos = userInfoMapper.selectList(userInfoMapperQueryWrapper);
        return  userInfos.get(0);
    }

    @Override
    public HashMap<String,Object> register(String userName, String pwd){
        QueryWrapper<UserInfo> userInfoMapperQueryWrapper = new QueryWrapper<>();
        userInfoMapperQueryWrapper.eq("user_name",userName);
        List<UserInfo> userInfos = userInfoMapper.selectList(userInfoMapperQueryWrapper);
        boolean flag = null != userInfos.get(0);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(flag) {
            hashMap.put("success",false);
            hashMap.put("msg","账号已存在");
            return hashMap;
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userName);
            userInfo.setUserPwd(pwd);
            userInfo.setUserState(true);
            userInfo.setCreateTime( "" + Calendar.getInstance().get(Calendar.YEAR));
            userInfoMapper.insert(userInfo);
            hashMap.put("success",true);
            hashMap.put("msg","创建成功！");
            hashMap.put("data",userInfo);
            return hashMap;
        }
    }

    @Override
    public HashMap<String, Object> updateUser(UserInfo userInfo) {

        HashMap<String, Object> hashMap = new HashMap<>();
        int oid = (Integer)request.getSession().getAttribute("oid");
        userInfo.setUserOid(oid);
        userInfoMapper.updateById(userInfo);
        hashMap.put("success",true);
        hashMap.put("msg","创建成功！");
        hashMap.put("data",userInfo);
        return hashMap;
    }



}
