package controller;

import com.github.pagehelper.Page;
import common.JsonResult;
import entity.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AdviceService;
import vo.AdviceVO;

import java.util.*;

@Component
@RequestMapping("/advices")
public class AdviceControler {
    @Autowired
    private AdviceService adviceService;
    @RequestMapping("/selectAdvices.do")
    @ResponseBody
    public Map<String, Object> allAdvice(String content, String title, Integer page, Integer limit){
        System.out.println("===================="+content);
        System.out.println("========================"+title);
        List<AdviceVO> adviceVOS = adviceService.selectByUid(title, content,page,limit);
        System.out.println(adviceVOS);
        long total = ((Page) adviceVOS).getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", adviceVOS);
        return map;
    }

    @RequestMapping("/updateAdvice.do")
    @ResponseBody
    public JsonResult update(Advice advice){
        adviceService.updateAdvice(advice);
        return new JsonResult(1,"修改成功");
    }

    @RequestMapping("/addAdvice.do")
    @ResponseBody
    public JsonResult addAdvice(String content, String title){
        Advice advice = new Advice();
        advice.setContent(content);
        advice.setTitle(title);
        advice.setUid(1);
        advice.setCreateDate(new Date());
        adviceService.addAdvice(advice);
        return  new JsonResult(1, "添加成功");
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public JsonResult delete(Integer id){
        adviceService.delete(id);
        return  new JsonResult(1,"删除成功");
    }

    @RequestMapping("/deletes.do")
    @ResponseBody
    public JsonResult deletes(String ids){
        System.out.println(ids);
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        adviceService.deletes(list);
        return  new JsonResult(1,"删除成功");
    }
}
