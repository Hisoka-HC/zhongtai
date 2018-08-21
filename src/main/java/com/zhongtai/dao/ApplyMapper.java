package com.zhongtai.dao;

import com.zhongtai.pojo.Apply;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ApplyMapper {
    public List<Apply> selectApply(Map<String, Object> params);
    public String count();
    public void insertApply(Map<String, Object> params);
    public void insertApply(Apply apply);
    public void deleteApply(Integer id);
    public void updateApply(Apply apply);
}
