package com.zhongtai.service;

import com.zhongtai.pojo.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> selectDepartment(Integer id);
    public void insertDepartment(Department department);
    public void updateDepartment(Department department);
    public void deleteDepartment(Integer id);
}
