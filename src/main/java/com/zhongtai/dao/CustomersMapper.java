package com.zhongtai.dao;

import com.zhongtai.pojo.Customers;
import com.zhongtai.pojo.Process;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomersMapper {
    public List<Customers> selectCustomers(Map<String, Object> params);
    public List<Customers> selectCustomerUserId(Map<String, Object> params);
    public List<Customers> selectCustomerGroupId(Map<String, Object> params);
    public List<Customers> selectCustomerDepartmentId(Map<String, Object> params);
    public List<Customers> selectPersonalCustomers(Map<String, Object> params);
    public String count();
    public String countPersonal();
    public List<Process> selectWhereId(Integer id);
    public void insertCustomers(Customers customers);
    public void deleteCustomers(Integer id);
    public void updateCustomers(Customers customers);
}
