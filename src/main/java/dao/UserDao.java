package dao;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    public User findByLoginName (String loginname);
    public List<User> selectAllUser();
    public void updateUser(User user);
    public User selectById (Integer id);
    public void deleteById(List list);
    public void addUser(User user);
    public List<User> selectByStatus(Integer status);
}
