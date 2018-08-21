package com.zhongtai.serviceimpl;

import com.zhongtai.dao.CustomersMapper;
import com.zhongtai.pojo.Customers;
import com.zhongtai.pojo.Process;
import com.zhongtai.service.CustomersService;
import com.zhongtai.util.SendMessageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("customersService")
public class CustomersServiceImpl implements CustomersService {


    @Resource
    CustomersMapper customersMapper;

    @Override
    public List<Customers> selectCustomers(Integer id, String search, Integer limit, Integer offset, String startTime, String endTime) {
        Map params = new HashMap();
        params.put("id",id);
        params.put("search",search);
        params.put("offset",offset);
        params.put("limit",limit);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        return customersMapper.selectCustomers(params);
    }

    @Override
    public List<Customers> selectPersonalCustomers(String search,Integer limit, Integer offset,String startTime,String endTime) {
        Map params = new HashMap();
        params.put("search",search);
        params.put("offset",offset);
        params.put("limit",limit);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        return customersMapper.selectPersonalCustomers(params);
    }

    @Override
    public String count() {
        return customersMapper.count();
    }

    @Override
    public String countPersonal(){
        return customersMapper.countPersonal();
    }

    /**
     * 分权限查询
     * @return
     */
    @Override
    public List<Customers> selectCustomers(Integer id, Integer userId,String search, Integer limit, Integer offset, String startTime, String endTime, Integer roleId, Integer groupId, Integer departmentId) {
        Map params = new HashMap();
        params.put("id",id);
        params.put("userId",userId);
        params.put("search",search);
        params.put("offset",offset);
        params.put("limit",limit);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        params.put("roleId",roleId);
        params.put("groupId",groupId);
        params.put("departmentId",departmentId);
        if (roleId==4 && userId!=null){
           return customersMapper.selectCustomerUserId(params);
        }
        if (roleId==3 && groupId!=null){
           return customersMapper.selectCustomerGroupId(params);
        }
        if (roleId==2 && departmentId!=null){
           return customersMapper.selectCustomerDepartmentId(params);
        }
        return null;
    }

    @Override
    public void insertCustomers(Customers customers) {
        customersMapper.insertCustomers(customers);
    }

    @Override
    public void deleteCustomers(Integer id) {
        customersMapper.deleteCustomers(id);
    }



    @Override
    public void updateCustomers(Customers customers) {
        customersMapper.updateCustomers(customers);
    }

    /**
     * 未完成的 修改进度 短信通知功能
     * @param customers
     * @return
     */
    public void updateCustomers(Customers customers,Integer integer) {
        Integer id = customers.getId();
        List<Process> listFormer = customersMapper.selectWhereId(id);
        String formerName = listFormer.get(0).getMessage();
        customersMapper.updateCustomers(customers);

        List<Process> list = customersMapper.selectWhereId(id);
        String updateName = list.get(0).getMessage();
        String name = list.get(0).getName();
        String sex = list.get(0).getSex();
        StringBuffer sb=new StringBuffer();
        if (sex=="男"){
            sb.append("先生");
        }else {
            sb.append("女士");
        }
        String newsex = sb.toString();
        if (formerName!=updateName){
            SendMessageUtil.sendProcess(list.get(0).getPhone(),updateName,name,newsex);
        }

    }



}
