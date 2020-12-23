package dao;

import entity.Reimbursement;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.ReimbursementVo;

import java.util.Date;
import java.util.List;

public interface ReimbursementDao {
    public List<ReimbursementVo> selectAllReimbursement
            (@Param("name") String name, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    public void addReimbursement(Reimbursement reimbursement);
}
