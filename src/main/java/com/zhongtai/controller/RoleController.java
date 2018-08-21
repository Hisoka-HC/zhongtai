package com.zhongtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhongtai.pojo.Role;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.RoleService;
import com.zhongtai.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RoleController {

    @Resource
    RoleService roleService;

    @RequestMapping(value = "role/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectRole(HttpSession session, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Role> list = roleService.selectRole();
        JSONArray array =(JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }
}
