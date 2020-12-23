package service;

import dao.ReimbursementDao;
import entity.Reimbursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.ReimbursementVo;

import java.util.Date;
import java.util.List;

@Component
public class ReimBursementServiceImpl implements ReimBursementService {
    @Autowired
    private ReimbursementDao reimbursementDao;
    @Override
    public List<ReimbursementVo> selectAllReimbursement(String name, Date beginTime, Date endTime) {
        return reimbursementDao.selectAllReimbursement(name,beginTime,endTime);
    }

    @Override
    public void addReimbursement(Reimbursement reimbursement) {
        reimbursementDao.addReimbursement(reimbursement);
    }
}
