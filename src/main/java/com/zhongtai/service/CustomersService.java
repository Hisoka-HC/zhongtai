package com.zhongtai.service;

import com.zhongtai.pojo.Customers;

import java.util.List;

public interface CustomersService {

    public List<Customers> selectCustomers(Integer id, String search, Integer limit, Integer offset, String startTime, String endTime);
    public List<Customers> selectPersonalCustomers(String search,Integer limit, Integer offset,String startTime,String endTime);
    public String count();
    public String countPersonal();
    public List<Customers> selectCustomers(Integer id, Integer userId,String search, Integer limit, Integer offset, String startTime, String endTime,Integer roleId,Integer groupId,Integer departmentId);
    public void insertCustomers(Customers customers);
    public void deleteCustomers(Integer id);
    public void updateCustomers(Customers customers);
}
