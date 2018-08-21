package com.zhongtai.dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.zhongtai.pojo.Apply;
import com.zhongtai.pojo.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UsersMapper {
    public List<Users> selectUsers(Map<String, Object> params);
    public List<Users> selectUsersId(Map<String, Object> params);
    public List<Users> selectUsersGroupId(Map<String, Object> params);
    public List<Users> selectUsersDepartmentId(Map<String, Object> params);

    public Users login(Map<String, Object> params);
    public String count();
    public void insertUsers(Users users);
    public void deleteUsers(Integer id);
    public void updateUsers(Users users);
}
