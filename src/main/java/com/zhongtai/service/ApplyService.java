package com.zhongtai.service;

import com.zhongtai.pojo.Apply;

import java.util.Date;
import java.util.List;

public interface ApplyService {
    public List<Apply> selectApply(Integer id, String search, Integer limit, Integer offset, String startTime, String endTime);
    public String count();
    public void insertApply(Apply apply);
    public void insertApply(Integer phone,Integer money,String name);
    public void deleteApply(Integer id);
    public void updateApply(Apply apply);
}
