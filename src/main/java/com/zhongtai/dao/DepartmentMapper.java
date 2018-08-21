package com.zhongtai.dao;

import com.zhongtai.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartmentMapper {
    public List<Department> selectDepartment(Map<String, Object> params);
    public void insertDepartment(Department department);
    public void updateDepartment(Department department);
    public void deleteDepartment(Integer id);
}
