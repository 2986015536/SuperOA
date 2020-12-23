package service;

import com.github.pagehelper.PageHelper;
import dao.AdviceDao;
import entity.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.AdviceVO;

import java.util.List;

@Component
public class AdviceServiceImpl implements AdviceService{
    @Autowired
    private AdviceDao adviceDao;


    @Override
    public List<AdviceVO> selectByUid(String title, String content, Integer page, Integer limit) {
        Advice advice = new Advice();
        advice.setTitle(title);
        advice.setContent(content);

        // 设置页码和每页显示的记录数，该语句后面一定要紧跟着数据库查询语句
        PageHelper.startPage(page,limit);
        List<AdviceVO> list = adviceDao.selectByUid(advice);
        return list;
    }

    @Override
    public void updateAdvice(Advice advice) {
        adviceDao.updateAdvice(advice);
    }

    @Override
    public void addAdvice(Advice advice) {
        adviceDao.addAdvice(advice);
    }

    @Override
    public void delete(Integer id) {
        adviceDao.delete(id);
    }

    @Override
    public void deletes(List list) {
        adviceDao.deletes(list);
    }
}
