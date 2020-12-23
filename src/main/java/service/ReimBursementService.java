package service;

import entity.Reimbursement;
import org.apache.ibatis.annotations.Param;
import vo.ReimbursementVo;

import java.util.Date;
import java.util.List;

public interface ReimBursementService {
    public List<ReimbursementVo> selectAllReimbursement (String name, Date beginTime, Date endTime);

    public void addReimbursement(Reimbursement reimbursement);
}
