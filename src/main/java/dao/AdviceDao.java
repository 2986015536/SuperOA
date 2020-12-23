package dao;

import entity.Advice;
import org.apache.ibatis.annotations.Param;
import vo.AdviceVO;

import java.util.List;

public interface AdviceDao {
    public List<AdviceVO> selectByUid(Advice advice);
    public void updateAdvice(Advice advice);
    public void addAdvice(Advice advice);
    public void delete(Integer id);
    public void deletes(List list);
}
