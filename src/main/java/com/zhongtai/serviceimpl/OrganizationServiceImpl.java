package com.zhongtai.serviceimpl;

import com.zhongtai.dao.OrganizationMapper;
import com.zhongtai.pojo.Organization;
import com.zhongtai.service.OrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    OrganizationMapper organizationMapper;

    @Override
    public List<Organization> selectOrganization(Integer id,Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("id",id);
        params.put("limit",limit);
        params.put("offset",offset);
        return organizationMapper.selectOrganization(params);
    }

    @Override
    public String count() {
        return organizationMapper.count();
    }

    @Override
    public void insertOrganization(Organization organization) {
        organizationMapper.insertOrganization(organization);
    }

    @Override
    public void deleteOrganization(Integer id) {
        organizationMapper.deleteOrganization(id);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationMapper.updateOrganization(organization);
    }
}
