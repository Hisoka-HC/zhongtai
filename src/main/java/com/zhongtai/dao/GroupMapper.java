package com.zhongtai.dao;

import com.zhongtai.pojo.Groups;

import java.util.List;
import java.util.Map;

public interface GroupMapper {
    public List<Groups> selectGroup(Map<String, Object> params);
    public List<Groups> selectGroupByName(Map<String, Object> params);
    public void insertGroup(Map<String, Object> params);
    public void updateGroup(Groups groups);
    public void insertDepartmentGroup(Map<String, Object> params);
}
