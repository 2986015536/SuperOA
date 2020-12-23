package controller;

import common.JsonResult;
import entity.Reimbursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ReimBursementService;
import vo.ReimbursementVo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/reim")
public class ReimBursementController {
    @Autowired
    private ReimBursementService reimBursementService;
    @RequestMapping("/selectReimbursement.do")
    @ResponseBody
    public Map<String, Object> selectReimbursement(String name, Date beginTime, Date endTime){
        List<ReimbursementVo> list = reimBursementService.selectAllReimbursement(name, beginTime, endTime);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 100);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/addReimbursement.do")
    @ResponseBody
    public JsonResult addReimbursement(Reimbursement reimbursement){
        System.out.println("==============================");
        System.out.println(reimbursement);
        reimBursementService.addReimbursement(reimbursement);
        return new JsonResult(1,"申请成功");
    }
}
