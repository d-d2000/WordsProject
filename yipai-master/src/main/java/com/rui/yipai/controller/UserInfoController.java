package com.rui.yipai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rui.yipai.entity.UserInfo;
import com.rui.yipai.entity.WordsInfo;
import com.rui.yipai.mapper.UserInfoMapper;
import com.rui.yipai.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yr
 * @since 2024-03-25
 */
@RestController
@RequestMapping("/yipai/userInfo")
public class UserInfoController {


    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("login")
    public HashMap<String,Object> userLogin(HttpServletRequest request, String userName, String pwd) {
        HashMap<String, Object> hashMap = userInfoService.userLogin(userName, pwd);
        UserInfo userInfo = (UserInfo)hashMap.get("data");
        if(null != userInfo) {
            HttpSession session = request.getSession();
            session.setAttribute("userName",userInfo.getUserName());
            session.setAttribute("password",userInfo.getUserPwd());
            session.setAttribute("oid",userInfo.getUserOid());
        }
        return hashMap;

    }

    @RequestMapping("register")
    public HashMap<String,Object> register(HttpServletRequest request,String userName, String pwd) {
        HashMap<String, Object> hashMap = userInfoService.register(userName,pwd);
        UserInfo userInfo = (UserInfo)hashMap.get("data");
        if(null != userInfo) {
            HttpSession session = request.getSession();
            session.setAttribute("userName",userInfo.getUserName());
            session.setAttribute("password",userInfo.getUserPwd());
            session.setAttribute("oid",userInfo.getUserOid());
        }
        return hashMap;
    }

    @RequestMapping("update")
    public HashMap<String,Object> updateUser(UserInfo userInfo) {
        return userInfoService.updateUser(userInfo);
    }


    @Autowired
    UserInfoMapper userInfoMapper;

    @RequestMapping("getAllUser")
    public HashMap<String, Object>  updateUser(int start,int limit) {
        Page<UserInfo> userInfoPage = new Page<>();
        userInfoPage.setCurrent(start);
        userInfoPage.setSize(limit);
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        Page<UserInfo> wordsInfoPage1 = userInfoMapper.selectPage(userInfoPage, queryWrapper);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("success",true);
        hashMap.put("msg","修改成功！");
        hashMap.put("data",wordsInfoPage1);
        return hashMap;
    }
}
