package controller;

import com.alibaba.fastjson.JSONObject;
import common.JsonResult;
import entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.JobService;
import vo.JobInfoVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping("/selectJob.do")
    @ResponseBody
    public Map<String, Object> selectJob (String leadName, String position) {
        List<JobInfoVO> list = jobService.allJobDao(leadName, position);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 100);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/selectJobName.do")
    @ResponseBody
    public JsonResult selectJobName () {
        List<Job> jobs = jobService.selectJobName();
        return new JsonResult(1,jobs);
    }

    @RequestMapping("/addJob.do")
    @ResponseBody
    public JsonResult addJob (String name, String remanrk) {
        Job job = new Job();
        job.setName(name);
        job.setRemark(remanrk);
        jobService.addJob(job);
        return new JsonResult(1, "添加成功");
    }

    @RequestMapping("/deleteJobInfo.do")
    @ResponseBody
    public JsonResult deleteJobInfo (Integer id) {
        jobService.deleteJobInfo(id);
        return new JsonResult(1,"删除成功");
    }
    @RequestMapping("/deleteLotsJob.do")
    @ResponseBody
    public JsonResult deleteLotsJob (String ids) {
        int length = ids.length();
        String substring = ids.substring(1,length-1);
        String[] split = substring.split(",");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        jobService.deleteLotsJob(list);
        return new JsonResult(1,"删除成功");
    }

}
