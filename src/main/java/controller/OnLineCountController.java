package controller;

import common.JsonResult;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class OnLineCountController {
    @Autowired
    private UserService userService;
    @RequestMapping("/count.do")
    @ResponseBody
    public JsonResult onLineCount() {
        List<User> list = userService.selectByStatus(1);
        int size = list.size();
        return new JsonResult(1, size);

    }
}
