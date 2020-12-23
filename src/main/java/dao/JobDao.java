package dao;

import entity.Job;
import org.apache.ibatis.annotations.Param;
import vo.JobInfoVO;

import java.util.List;

public interface JobDao {
    public List<JobInfoVO> allJobDao(@Param("leadName") String leadName, @Param("position") String position);
    public List<Job> selectJobName();
    public void addJob(Job job);
    public void deleteJobInfo(Integer id);
    public void deleteLotsJob(List list);
}
