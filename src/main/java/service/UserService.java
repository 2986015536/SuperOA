package service;

import entity.User;

import java.util.List;

public interface UserService {
    public User findByLoginName (String loginname, String password);
    public List<User> selectAllUser () ;
    public void updateUser(User user);
    public User selectById (Integer id);
    public void deleteById (String ids);
    public void addUser(User user);
    public void updateHeadImg(User user);
    public User selectByLoginName (String loginname);
    public List<User> selectByStatus(Integer status);
}
