package com.zhongtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhongtai.pojo.Groups;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.GroupService;
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
public class GroupController {

    @Resource
    GroupService groupService;

    @RequestMapping(value = "group/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectGroup(HttpSession session, HttpServletResponse response, HttpServletRequest request,Integer departmentId,Integer id){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Groups> list = groupService.selectGroup(departmentId,id);
        JSONArray array =(JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }

    @RequestMapping(value = "group/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertGroup(HttpSession session, HttpServletResponse response, HttpServletRequest request,String name,Integer departmentId){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        groupService.insertGroup(name,departmentId);
        return "success";
    }

    @RequestMapping(value = "group/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateGroup(HttpSession session, HttpServletResponse response, HttpServletRequest request,Groups groups){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        groupService.updateGroup(groups);
        return "success";
    }


    /**
     * 把小组分在哪个部门下面去
     * @param session
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "group/addDepartment.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addDepartment(HttpSession session, HttpServletResponse response, HttpServletRequest request,Integer departmentId,Integer groupId){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        groupService.insertDepartmentGroup(departmentId, groupId);
        return "success";
    }

}
