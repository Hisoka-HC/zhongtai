package com.zhongtai.service;

import com.zhongtai.pojo.Users;

import java.util.List;

public interface UsersService {

    public List<Users> selectUsers(Integer id,String search,Integer limit, Integer offset);
    public List<Users> selectUsers(Integer id,String search,Integer limit, Integer offset,Integer roleId,Integer groupId,Integer departmentId);
    public String count();
    public Users login(Users users);
    public String insertUsers(Users users);
    public void deleteUsers(Integer id);
    public void updateUsers(Users users);
}
