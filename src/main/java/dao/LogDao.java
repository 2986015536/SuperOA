package dao;

import entity.LoginLog;

public interface LogDao {
    public LoginLog selectOneLoginLog(Integer uid);
    public void addLoginLog(LoginLog loginLog);
}
