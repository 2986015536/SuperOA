package controller;

import common.JsonResult;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.EmployeeService;
import vo.EmployeeVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("employee")
public class EmployController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/selectFuzzy.do")
    @ResponseBody
    private Map<String, Object> selectFuzzy(Employee employee){
        Map<String, Object> map = new HashMap<>();
        List<EmployeeVO> list = employeeService.allEmployee(employee);


        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 100);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public JsonResult update (Employee employee) {
        employeeService.updateEmployee(employee);
        return new JsonResult(1,"修改成功");
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public JsonResult add(Employee employee){
        employeeService.addEmployee(employee);
        return  new JsonResult(1, "添加成功");
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public JsonResult delete(String ids){
        System.out.println(ids);
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        employeeService.deleteById(list);
        return new JsonResult(1,"删除成功");
    }

}
