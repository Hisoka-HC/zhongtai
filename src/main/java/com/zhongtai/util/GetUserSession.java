package com.zhongtai.util;

import com.zhongtai.pojo.Users;

import javax.servlet.http.HttpSession;

public class GetUserSession {

    public static Users getSessionUser(HttpSession httpSession) {
        Object tmp = httpSession.getAttribute("user");
        if (tmp == null)
            return null;
        else
            return (Users) tmp;
    }
}
