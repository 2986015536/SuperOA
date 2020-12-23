package controller;

import common.JsonResult;
import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.config.JeeNamespaceHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DeptService;
import vo.DeptVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

@Component
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/selectDept.do")
    @ResponseBody
    public Map<String, Object> selectDept(String dname){
        DeptVO deptVO1 = new DeptVO();
        deptVO1.setDname(dname);
        List<DeptVO> deptVOS = deptService.selectDept(deptVO1);
        for (DeptVO deptVO : deptVOS) {
            System.out.println(deptVO);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",100);
        map.put("data", deptVOS);
        return map;
    }

    @RequestMapping("/updateDept.do")
    @ResponseBody
    public JsonResult updateDept (Integer id, String  name,String remark) {
        Dept dept = new Dept();
        dept.setId(id);
        dept.setName(name);
        dept.setRemark(remark);
        deptService.updateDept(dept);
        return new JsonResult(1,"修改成功");
    }
    @RequestMapping("/addDept.do")
    @ResponseBody
    public JsonResult addDept (String name, String remark) {
        Dept dept = new Dept();
        dept.setName(name);
        dept.setRemark(remark);
        deptService.addDept(dept);
        return  new JsonResult(1,"添加成功");
    }
    @RequestMapping("/deleteDeptById.do")
    @ResponseBody
    public JsonResult deleteById (String did) {
        Integer id = Integer.parseInt(did);
        deptService.deleteById(id);
        return new JsonResult(1, "删除成功");
    }
    @RequestMapping("/deleteDeptByIds.do")
    @ResponseBody
    public JsonResult deleteByIds (String dids) {

        int length = dids.length();
        String substring = dids.substring(1,length-1);
        String[] split = substring.split(",");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }

        deptService.deleteByIds(list);
        return new JsonResult(1, "删除成功");
    }
}
