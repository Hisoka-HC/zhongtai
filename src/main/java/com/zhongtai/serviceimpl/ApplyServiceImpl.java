package com.zhongtai.serviceimpl;

import com.zhongtai.dao.ApplyMapper;
import com.zhongtai.pojo.Apply;
import com.zhongtai.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ApplyService")
public class ApplyServiceImpl implements ApplyService {

    @Resource
    ApplyMapper applyMapper;

    @Override
    public List<Apply> selectApply(Integer id, String search, Integer limit, Integer offset, String startTime, String endTime) {
        Map params = new HashMap();
        params.put("id",id);
        params.put("search",search);
        params.put("limit",limit);
        params.put("offset",offset);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        return applyMapper.selectApply(params);
    }

    @Override
    public String count() {

        return applyMapper.count();
    }

    @Override
    public void insertApply(Apply apply) {
        applyMapper.insertApply(apply);
    }

    @Override
    public void insertApply(Integer phone, Integer money, String name) {
        Map params = new HashMap();
        params.put("name",name);
        params.put("phone",phone);
        params.put("money",money);
        applyMapper.insertApply(params);
    }

    @Override
    public void deleteApply(Integer id) {
        applyMapper.deleteApply(id);
    }

    @Override
    public void updateApply(Apply apply) {
        applyMapper.updateApply(apply);
    }
}
