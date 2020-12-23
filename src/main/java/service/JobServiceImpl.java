package service;

import dao.JobDao;
import entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.JobInfoVO;

import java.util.List;

@Component
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;
    @Override
    public List<JobInfoVO> allJobDao(String leadName, String position) {
        return jobDao.allJobDao(leadName, position);
    }

    @Override
    public List<Job> selectJobName() {
        return jobDao.selectJobName();
    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);
    }

    @Override
    public void deleteJobInfo(Integer id) {
        jobDao.deleteJobInfo(id);
    }

    @Override
    public void deleteLotsJob(List list) {
        jobDao.deleteLotsJob(list);
    }
}
