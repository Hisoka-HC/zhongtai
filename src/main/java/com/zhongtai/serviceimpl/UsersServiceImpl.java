package com.zhongtai.serviceimpl;

import com.zhongtai.dao.UsersMapper;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public List<Users> selectUsers(Integer id,String search,Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("id",id);
        params.put("search",search);
        params.put("limit",limit);
        params.put("offset",offset);
        return usersMapper.selectUsers(params);
    }

    @Override
    public List<Users> selectUsers(Integer id, String search, Integer limit, Integer offset, Integer roleId, Integer groupId, Integer departmentId) {
        Map params = new HashMap();
        params.put("id",id);
        params.put("search",search);
        params.put("limit",limit);
        params.put("offset",offset);
        params.put("roleId",roleId);
        params.put("groupId",groupId);
        params.put("departmentId",departmentId);
        if (roleId==4 && id!=null){
            return usersMapper.selectUsersId(params);
        }
        if (roleId==3 && groupId!=null){
            return usersMapper.selectUsersGroupId(params);
        }
        if (roleId==2 && departmentId!=null){
            return usersMapper.selectUsersDepartmentId(params);
        }
        return null;
    }

    @Override
    public String count() {
        return usersMapper.count();
    }

    @Override
    public Users login(Users users) {
        Map params = new HashMap();
        params.put("username",users.getUsername());
        params.put("password",users.getPassword());
        return usersMapper.login(params);
    }

    @Override
    public String insertUsers(Users users){

        try {
            usersMapper.insertUsers(users);
        } catch (Exception e) {
            e.printStackTrace();
            return "用户名已存在！";
        }
        return "success";
    }

    @Override
    public void deleteUsers(Integer id) {
        usersMapper.deleteUsers(id);
    }

    @Override
    public void updateUsers(Users users) {
        usersMapper.updateUsers(users);
    }
}
