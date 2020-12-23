package service;

import dao.LogDao;
import dao.UserDao;
import entity.LoginLog;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private LogDao logDao;
    @Override
    public User findByLoginName(String loginname, String password) {
        User user = userDao.findByLoginName(loginname);
        if (user == null) {
            throw new RuntimeException("账号不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        if (user.getStatus() == 1) {
            throw new RuntimeException("密码已在异地登陆");
        }
//        LoginLog loginLog1 = logDao.selectOneLoginLog(user.getId());
//
//        Integer loginCount = loginLog1.getLoginCount();
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUid(user.getId());
//        loginLog.setLoginCount(loginCount + 1);
//        Date date = new Date();
//        int time = date.getHours();
//        date.setHours(time + 8);
//        loginLog.setLoginTime(date);
//        logDao.addLoginLog(loginLog);

        return user;
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public void deleteById(String ids) {
        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        userDao.deleteById(list);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateHeadImg(User user) {

        userDao.updateUser(user);
    }

    @Override
    public User selectByLoginName(String loginname) {
        return userDao.findByLoginName(loginname);
    }

    @Override
    public List<User> selectByStatus(Integer status) {
        return userDao.selectByStatus(status);
    }


}
