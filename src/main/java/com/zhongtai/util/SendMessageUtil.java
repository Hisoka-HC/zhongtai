package com.zhongtai.util;

import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class SendMessageUtil {
    /**
     * 给用户发送贷款进度短信
     * @param
     * @return
     */
    public static String sendProcess(String phoneNumber,String process,String name,String sex){
        try{
            String host = "http://cowsms.market.alicloudapi.com";
            String path = "/intf/smsapi";
            String method = "GET";
            String appcode = "685e56af7bd4437a9e18b8de033f06c0";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("mobile", phoneNumber);
            querys.put("paras", "1234,2");
            querys.put("sign", "消息通"+process);
            querys.put("tpid", "009");
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            if (response.toString()!=null){
                return "success";
            }
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }

    public static String sendCode(String phoneNumber,int code){
        try{
            String host = "http://cowsms.market.alicloudapi.com";
            String path = "/intf/smsapi";
            String method = "GET";
            String appcode = "685e56af7bd4437a9e18b8de033f06c0";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("mobile", phoneNumber);
            querys.put("paras", "1234,2");
            querys.put("sign", "消息通"+code);
            querys.put("tpid", "009");
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            if (response.toString()!=null){
                return "success";
            }
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
