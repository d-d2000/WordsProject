package com.rui.yipai.controller;

import com.rui.yipai.entity.UserInfo;
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

    @RequestMapping("getAllUser")
    public List<UserInfo> updateUser() {
        return userInfoService.list();
    }
}
