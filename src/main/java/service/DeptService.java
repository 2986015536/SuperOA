package service;

import entity.Dept;
import vo.DeptVO;

import java.util.List;

public interface DeptService {
    public List<DeptVO> selectDept(DeptVO deptVO);
    public void updateDept(Dept dept);
    public void addDept (Dept dept);
    public void deleteById(Integer id);
    public void deleteByIds(List list);
}
