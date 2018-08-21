package com.zhongtai.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongtai.pojo.Customers;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.CustomersService;
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
public class CustomersController {

    @Resource
    CustomersService customersService;

    @RequestMapping(value = "customers/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectCustomers(HttpSession session, HttpServletResponse response, HttpServletRequest request, String search, Integer id, Integer limit, Integer offset, String startTime, String endTime){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Customers> list = customersService.selectCustomers(id,search,limit,offset,startTime,endTime);
        JSONObject result= new JSONObject();
        result.put("row",list);
        result.put("total",list.size());
        return result.toJSONString();
    }

    @RequestMapping(value = "customers/selectByRole.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectCustomer(HttpSession session, HttpServletResponse response, HttpServletRequest request, String search, Integer id, Integer userId,Integer limit, Integer offset, String startTime, String endTime, Integer roleId, Integer groupId, Integer departmentId){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Customers> list = customersService.selectCustomers(id, userId, search, limit, offset, startTime, endTime, roleId, groupId, departmentId);
        JSONObject result= new JSONObject();
        result.put("row",list);
        result.put("total",list.size());
        return result.toJSONString();
    }

    @RequestMapping(value = "customers/count.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String count(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return customersService.count();
    }

    @RequestMapping(value = "customers/countPersonal.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String countPersonal(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return customersService.countPersonal();
    }

    /**
     * 查找个人客户：没人推荐人的客户
     * @return
     */
    @RequestMapping(value = "customers/selectPersonal.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectPersonalCustomers(HttpSession session, HttpServletResponse response, HttpServletRequest request, String search, Integer limit, Integer offset, String startTime, String endTime){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Customers> list = customersService.selectPersonalCustomers(search,limit,offset,startTime,endTime);
        JSONObject result= new JSONObject();
        result.put("row",list);
        result.put("total",list.size());
        return result.toJSONString();
    }

    @RequestMapping(value = "customers/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertCustomers(HttpSession session,Customers customers,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        customersService.insertCustomers(customers);
        System.out.println(customers.getOrganizeId());
        return "success";
    }

    @RequestMapping(value = "customers/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateCustomers(HttpSession session,Customers customers,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        customersService.updateCustomers(customers);

        return "success";
    }

    @RequestMapping(value = "customers/delete.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteCustomers(HttpSession session,Integer id,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        customersService.deleteCustomers(id);
        return "success";
    }
}
