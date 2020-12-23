package service;

import dao.DeptDao;
import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.DeptVO;

import java.util.List;

@Component
public class DeptServiceImpl  implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public List<DeptVO> selectDept(DeptVO deptVO) {
        return deptDao.selectDept(deptVO);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public void deleteById(Integer id) {
        deptDao.deleteById(id);
    }

    @Override
    public void deleteByIds(List list) {

        deptDao.deleteByIds(list);
    }
}
