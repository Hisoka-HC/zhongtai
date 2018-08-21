package com.zhongtai.service;

import com.zhongtai.pojo.Groups;

import java.util.List;

public interface GroupService {
    public List<Groups> selectGroup(Integer departmentId,Integer id);
    public String insertGroup(String name,Integer departmentId);
    public void updateGroup(Groups groups);
    public void insertDepartmentGroup(Integer departmentId,Integer groupId);
}
