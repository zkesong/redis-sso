package cn.qydx.service.sso.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qydx.service.sso.constant.ResponseCode;
import cn.qydx.service.sso.dao.UserInfoMapper;
import cn.qydx.service.sso.model.UserInfo;
import cn.qydx.service.sso.utils.RedisUtil;
import cn.qydx.service.sso.utils.Response;

@RequestMapping("sso")
@Controller
public class LoginController {

    @Autowired
    private UserInfoMapper mapper;

    @Autowired
    private RedisUtil util;
    
    private String currentServiceName;

    @RequestMapping("login")
    public String loginPage(@RequestParam String service) {
    	this.currentServiceName = service;
    	System.out.println(currentServiceName);
    	return "login";
    }
    
    @RequestMapping("userInfo")
    @ResponseBody
    public Response<UserInfo> getUserInfo(@CookieValue(value = "sessionId", required = false) String sessionId){
        UserInfo userInfo = (UserInfo) util.get(sessionId);
        return new Response<>(userInfo, ResponseCode.REQUEST_SUCCESS);
    }

    @PostMapping("doLogin")
    @ResponseBody
    public Response<UserInfo> login(@RequestParam String name, @RequestParam String passwd, HttpServletResponse response){
        UserInfo info = mapper.getUserInfoByName(name);
        if(passwd!=null && info != null &&passwd.equals(info.getPasswd())){
            String id = UUID.randomUUID().toString();
            String head = "ticket";
            String sessionId = head + ":" + id;
            Cookie cookie = new Cookie("sessionId", sessionId);
            response.addCookie(cookie);
            util.set(sessionId, info, 30 * 60);
            return new Response<>(info, ResponseCode.REQUEST_SUCCESS);
        }
        return new Response<>(null, ResponseCode.REQUEST_FAILED);
    }
    
    @GetMapping("doLogout")
    @ResponseBody
    public Response<String> logout(@CookieValue(value = "sessionId", required = false) String sessionId){
    	 util.del(sessionId);
         return new Response<>("success", ResponseCode.REQUEST_SUCCESS);
    }
}
