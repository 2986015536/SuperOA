package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class OutController {
    @Autowired
    private UserService userService;

    @RequestMapping("http://localhost:8080/user/out.do")
    public void out(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // session若不存在 返回null
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User)session.getAttribute("loginUser");
            user.setStatus(0);
            userService.updateUser(user);
            // 销毁session
            session.invalidate();
        }
        // 重定向到登录页面
        response.sendRedirect("http://localhost:8080/SuperOA/after/user/login.html" );

    }

}
