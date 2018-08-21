package com.zhongtai.serviceimpl;

import com.zhongtai.dao.RoleMapper;
import com.zhongtai.pojo.Role;
import com.zhongtai.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> selectRole() {
        return roleMapper.selectRole();
    }
}
