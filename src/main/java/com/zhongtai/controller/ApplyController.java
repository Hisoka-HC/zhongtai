package com.zhongtai.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongtai.pojo.Apply;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.ApplyService;
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
public class ApplyController {

    @Resource
    ApplyService applyService;

    @RequestMapping(value = "apply/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectApply(HttpSession session, HttpServletResponse response, HttpServletRequest request, Integer id, String search, Integer limit, Integer offset,String startTime, String endTime){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Apply> applylist = applyService.selectApply(id,search,limit,offset,startTime,endTime);
        JSONObject result= new JSONObject();
        result.put("row",applylist);
        result.put("total",applylist.size());
        return result.toJSONString();
    }

    @RequestMapping(value = "apply/count.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String count(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return applyService.count();
    }

    @RequestMapping(value = "apply/insert.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertApply(HttpSession session,Apply apply,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        applyService.insertApply(apply);
        return "success";
    }

    @RequestMapping(value = "apply/delete.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteApply(HttpSession session,Integer id,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        applyService.deleteApply(id);
        return "success";
    }

    @RequestMapping(value = "apply/update.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateApply(HttpSession session,Apply apply,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        applyService.updateApply(apply);
        return "success";
    }
}
