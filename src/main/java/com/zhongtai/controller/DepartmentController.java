package com.zhongtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhongtai.pojo.Department;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.DepartmentService;
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
public class DepartmentController {

    @Resource
    DepartmentService departmentService;

    @RequestMapping(value = "department/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectDepartment(HttpSession session, HttpServletResponse response, HttpServletRequest request,Integer id){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Department> list = departmentService.selectDepartment(id);
        JSONArray array =(JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }

    @RequestMapping(value = "department/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertDepartment(HttpSession session, HttpServletResponse response, HttpServletRequest request,Department department){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        departmentService.insertDepartment(department);
        return "success";
    }

    @RequestMapping(value = "department/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateDepartment(HttpSession session, HttpServletResponse response, HttpServletRequest request,Department department){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        departmentService.updateDepartment(department);
        return "success";
    }


}
