package service;

import dao.BankAccountDao;
import entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.BankAccountVo;

import java.util.Date;
import java.util.List;

@Component
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public List<BankAccountVo> selectBankAccount(String name, Date beginTime, Date endTime) {
        return bankAccountDao.selectBankAccount(name, beginTime, endTime);
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        bankAccountDao.updateBankAccount(bankAccount);
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountDao.addBankAccount(bankAccount);
    }

    @Override
    public void deleteAccountById(Integer id) {
        bankAccountDao.deleteAccountById(id);
    }

    @Override
    public void deleteAccountByIds(List list) {
        bankAccountDao.deleteAccountByIds(list);
    }
}
