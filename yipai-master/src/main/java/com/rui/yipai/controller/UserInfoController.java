package com.rui.yipai.controller;

import com.rui.yipai.entity.UserInfo;
import com.rui.yipai.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
        UserInfo userInfo = userInfoService.userLogin(userName, pwd);
        HashMap<String,Object> hashMap = new HashMap<>();
        if(null != userInfo) {

            HttpSession session = request.getSession();
            session.setAttribute("userName",userInfo.getUserName());
            session.setAttribute("password",userInfo.getUserPwd());
            session.setAttribute("oid",userInfo.getUserOid());
            hashMap.put("success",true);
            hashMap.put("msg","登陆成功！");
        } else {
            hashMap.put("success",false);
            hashMap.put("msg","登陆失败！");
        }
        return hashMap;

    }

    @RequestMapping("register")
    public HashMap<String,Object> register(String userName, String pwd) {
        return userInfoService.register(userName,pwd);
    }

    @RequestMapping("update")
    public HashMap<String,Object> updateUser(UserInfo userInfo) {
        return userInfoService.updateUser(userInfo);
    }
}
