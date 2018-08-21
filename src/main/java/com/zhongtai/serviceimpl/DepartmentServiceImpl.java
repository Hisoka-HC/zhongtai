package com.zhongtai.serviceimpl;

import com.zhongtai.dao.DepartmentMapper;
import com.zhongtai.pojo.Department;
import com.zhongtai.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectDepartment(Integer id) {
        Map params = new HashMap();
        params.put("id",id);
        return departmentMapper.selectDepartment(params);
    }

    @Override
    public void insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentMapper.deleteDepartment(id);
    }
}
