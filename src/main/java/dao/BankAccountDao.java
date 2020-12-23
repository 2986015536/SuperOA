package dao;

import entity.BankAccount;
import org.apache.ibatis.annotations.Param;
import vo.BankAccountVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BankAccountDao {
    public List<BankAccountVo> selectBankAccount(@Param("name") String name, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    public void updateBankAccount(BankAccount bankAccount);
    public void addBankAccount (BankAccount bankAccount);
    public void deleteAccountById (Integer id);
    public void deleteAccountByIds (List list);
}
