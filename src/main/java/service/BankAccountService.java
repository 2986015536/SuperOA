package service;

import entity.BankAccount;
import vo.BankAccountVo;

import java.util.Date;
import java.util.List;

public interface BankAccountService {
    public List<BankAccountVo> selectBankAccount(String name, Date beginTime, Date endTime);
    public void updateBankAccount(BankAccount bankAccount);
    public void addBankAccount(BankAccount bankAccount);
    public void deleteAccountById (Integer id);
    public void deleteAccountByIds (List list);
}
