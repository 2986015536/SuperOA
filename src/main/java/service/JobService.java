package service;

import entity.Job;
import org.apache.ibatis.annotations.Param;
import vo.JobInfoVO;

import java.util.List;

public interface JobService {
    public List<JobInfoVO> allJobDao(String leadName, String position);
    public List<Job> selectJobName();
    public void addJob(Job job);
    public void deleteJobInfo(Integer id);
    public void deleteLotsJob(List list);
}
