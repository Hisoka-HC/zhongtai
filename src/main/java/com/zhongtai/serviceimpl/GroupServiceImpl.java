package com.zhongtai.serviceimpl;

import com.zhongtai.dao.GroupMapper;
import com.zhongtai.pojo.Groups;
import com.zhongtai.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
    @Resource
    GroupMapper groupMapper;

    @Override
    public List<Groups> selectGroup(Integer departmentId,Integer id) {
        Map params = new HashMap();
        params.put("departmentId",departmentId);
        params.put("id",id);
        return groupMapper.selectGroup(params);
    }

    @Override
    public String insertGroup(String name,Integer departmentId) {
        Map params = new HashMap();
        params.put("departmentId",departmentId);
        params.put("name",name);
        groupMapper.insertGroup(params);
        List<Groups> list = groupMapper.selectGroupByName(params);
        Integer groupId = list.get(0).getId();
        params.put("groupId",groupId);
        groupMapper.insertDepartmentGroup(params);
        return "success";
    }

    @Override
    public void updateGroup(Groups groups) {
        groupMapper.updateGroup(groups);
    }

    @Override
    public void insertDepartmentGroup(Integer departmentId,Integer groupId) {
        Map params = new HashMap();
        params.put("department",departmentId);
        params.put("groupId",groupId);
        groupMapper.insertDepartmentGroup(params);
    }
}
