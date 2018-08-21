package com.zhongtai.service;

import com.zhongtai.pojo.Organization;

import java.util.List;

public interface OrganizationService {
    public List<Organization> selectOrganization(Integer id,Integer limit, Integer offset);
    public String count();
    public void insertOrganization(Organization organization);
    public void deleteOrganization(Integer id);
    public void updateOrganization(Organization organization);
}
