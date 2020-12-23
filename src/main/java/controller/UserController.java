package controller;

import com.alibaba.druid.support.http.WebStatFilter;
import common.JsonResult;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.UserService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login (HttpSession session, String loginname, String password, String imageCode) {
        JsonResult jsonResult = null;
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        try {
            if (checkCode_session.equalsIgnoreCase(imageCode)) {
                User user = userService.findByLoginName(loginname, password);
                Date date = new Date();
                user.setLoginDate(date);
//                user.setStatus(1);
                userService.updateUser(user);
                session.setAttribute("loginUser", user);
                jsonResult = new JsonResult(1,user);
            } else {
                jsonResult = new JsonResult(0,"验证码错误");
            }
        } catch (Exception ex) {
            jsonResult = new JsonResult(0, ex.getMessage());
        }
        return jsonResult;
    }

    @RequestMapping("/selectUser.do")
    @ResponseBody
    public Map<String, Object> selectUser() {

        List<User> list = userService.selectAllUser();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 100);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/selectUserById.do")
    @ResponseBody
    public JsonResult selectById (Integer id) {
        User user = userService.selectById(id);
        return new JsonResult(1, user);
    }


    @RequestMapping("/updateUser.do")
    @ResponseBody
    public JsonResult updateUser (User user) {

        userService.updateUser(user);
        return new JsonResult(1,"修改成功");
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    public JsonResult deleteUser(String ids) {
        userService.deleteById(ids);
        return new JsonResult(1, "删除成功");
    }

    @RequestMapping("/addUser.do")
    @ResponseBody
    public JsonResult addUse (String loginname, String password, Integer status, String username) {
        User user = new User();
        user.setCreateDate(new Date());
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setStatus(status);
        user.setUsername(username);
        userService.addUser(user);
        return new JsonResult(1, "添加成功");
    }

    @RequestMapping("/batch.do")
    @ResponseBody
    public JsonResult imgPath (@RequestParam MultipartFile file, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user==null) {
            return new JsonResult(0,"未登录");
        }
        String str = "e:aaa/upload";
        String filename = file.getOriginalFilename();
        File file1 = new File(str);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File newFile = new File(file1, filename);
        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setImgPath("/upload/" + filename);
        userService.updateHeadImg(user);

        User user1 = userService.selectById(user.getId());
        session.setAttribute("loginUser", user1);

        return new JsonResult(1,"上传成功");

    }

    @RequestMapping("/queryName.do")
    @ResponseBody
    public JsonResult queryName(HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        return new JsonResult(1, user);
    }

    @RequestMapping("/register.do")
    @ResponseBody
    public JsonResult register (String loginname, String username, String password, String queryPassword) {
        User u = userService.selectByLoginName(loginname);
        if (u != null) {
            return new JsonResult(0,"用户已存在");
        }
        if (!password.equals(queryPassword)) {
            return new JsonResult(0,"密码不一致");
        }
        User user = new User();
        user.setCreateDate(new Date());
        user.setLoginname(loginname);
        user.setUsername(username);
        System.out.println(username);
        user.setPassword(password);
        user.setStatus(0);
        userService.addUser(user);
        return new JsonResult(1, "注册成功");

    }

    //    登录验证码
    @RequestMapping("/imageLogin.do")
    public void imageLogin(HttpSession session, HttpServletResponse response) {

        try {

            int width = 100;
            int height = 50;
//        创建一个验证码图片对象
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

//        美化图片
            Graphics g = image.getGraphics();   // 画笔对象
            g.setColor(Color.PINK);     //设置画笔颜色
            g.fillRect(0, 0, width, height);
//        图片边框
            g.setColor(Color.BLUE);
            g.drawRect(0, 0, width - 1, height - 1);

//        写验证码
            String str = "123456789";
//        生成随机角标
            Random ran = new Random();

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= 4; i++) {
                int index = ran.nextInt(str.length());
//            获取字符
                char ch = str.charAt(index);

                sb.append(ch);
//            写验证码
                g.drawString(ch + "", width / 5 * i, height / 2);
            }

            String checkCode_session = sb.toString();
//            验证码存入session
            session.setAttribute("checkCode_session", checkCode_session);

//        画干扰线
            g.setColor(Color.GREEN);
//        随机生成坐标点
            for (int i = 0; i < 10; i++) {
                int x1 = ran.nextInt(width);
                int x2 = ran.nextInt(width);

                int y1 = ran.nextInt(height);
                int y2 = ran.nextInt(height);
                g.drawLine(x1, y1, x2, y2);
            }

            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
