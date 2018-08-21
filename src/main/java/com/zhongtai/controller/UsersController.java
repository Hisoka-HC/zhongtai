package com.zhongtai.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.UsersService;
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
public class UsersController {

    @Resource
    UsersService usersService;

    @RequestMapping(value = "users/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertUsers(HttpSession session, Users users, HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        String returnName = usersService.insertUsers(users);
        return returnName;
    }

    @RequestMapping(value = "users/count.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String count(HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return usersService.count();
    }

    @RequestMapping(value = "users/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectUsers(HttpSession session,HttpServletResponse response,HttpServletRequest request,Integer id,String search,Integer limit, Integer offset){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Users> userslist = usersService.selectUsers(id,search,limit,offset);
        JSONObject result= new JSONObject();
        result.put("row",userslist);
        result.put("total",userslist.size());
        return result.toJSONString();
    }

    @RequestMapping(value = "users/selectByRole.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectUsers(HttpSession session,HttpServletResponse response,HttpServletRequest request,Integer id,String search,Integer limit, Integer offset,Integer roleId,Integer groupId,Integer departmentId){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Users> userslist = usersService.selectUsers(id, search, limit, offset, roleId, groupId, departmentId);
        JSONObject result= new JSONObject();
        result.put("row",userslist);
        try {
            result.put("total", userslist.size());
        }catch (NullPointerException e){
            result.put("total", 0);
        }
        return result.toJSONString();
    }

    @RequestMapping(value = "users/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateUsers(HttpSession session,Users users,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        usersService.updateUsers(users);
        return "success";
    }

    @RequestMapping(value = "users/delete.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteUsers(HttpSession session, Integer id, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        usersService.deleteUsers(id);
        return "success";
    }
}
