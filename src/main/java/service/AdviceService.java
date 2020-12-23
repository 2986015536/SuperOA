package service;

import entity.Advice;
import vo.AdviceVO;

import java.util.List;

public interface AdviceService {
    public List<AdviceVO> selectByUid(String title, String content, Integer page, Integer limit);
    public void updateAdvice(Advice advice);
    public void addAdvice(Advice advice);
    public void delete(Integer id);
    public void deletes(List list);

}
