package com.zhongtai;

import com.alibaba.fastjson.JSONObject;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.ApplyService;
import com.zhongtai.service.UsersService;
import com.zhongtai.util.SendMessageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MainController {

    @Resource
    ApplyService applyService;
    @Resource
    UsersService usersService;

    @RequestMapping(value = "login.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(Users users, HttpSession session, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = usersService.login(users);
        JSONObject result = new JSONObject();
        result.put("user",user);
        if(user!=null){
            session.setAttribute("user",user);
            return result.toJSONString();
        }
        return "failed";

    }

    @RequestMapping(value = "logout.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String logout(HttpSession session,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        session.setAttribute("user",null);
        return "success";
    }
    @RequestMapping(value = "register.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String register(HttpSession session,Integer id,Integer phone,Integer money,String name,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Integer identifyingCode =(Integer) session.getAttribute("code");
        if(id==identifyingCode){
            applyService.insertApply(phone,money,name);
            return "注册成功";
        }
        else {
            return "验证码错误";
        }
    }


    @RequestMapping(value = "code/send.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String setIdentifyingCode(HttpSession session,String phoneNumber,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        int identifyingCode = (int) ((Math.random() * 9 + 1) * 100000);
        session.setAttribute("code",identifyingCode);
        String send = SendMessageUtil.sendCode(phoneNumber, identifyingCode);
        if (send.equals("success")){
            return "发送成功";
        }
        return "发送失败";
    }

}
