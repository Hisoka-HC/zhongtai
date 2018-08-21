package com.zhongtai.dao;

import com.zhongtai.pojo.Process;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProcessMapper {
    public List<Process> selectProcess(Map<String, Object> params);
    public String count();
    public void insertProcess(Process process);
    public void deleteProcess(Integer id);
    public void updateProcess(Process process);
}
