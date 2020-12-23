package controller;

import common.JsonResult;
import entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BankAccountService;
import vo.BankAccountVo;

import java.util.*;

@Component
@RequestMapping("/bank")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @RequestMapping("/selectAccount.do")
    @ResponseBody
    public Map<String, Object> selectAccount(String name, Date beginTime, Date endTime) {
        List<BankAccountVo> bankAccountVos = bankAccountService.selectBankAccount(name, beginTime, endTime);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 100);
        map.put("data", bankAccountVos);
        return map;
    }
    @RequestMapping("/updateAccount.do")
    @ResponseBody
    public JsonResult updateAccount (Integer id, String account, String name, String bankName, Date createDate, Integer addressId) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(id);
        bankAccount.setAccount(account);
        bankAccount.setName(name);
        bankAccount.setCreate_bank_name(bankName);
        bankAccount.setCreate_date(createDate);
        bankAccount.setAddress_id(addressId);
        System.out.println(bankAccount);
        bankAccountService.updateBankAccount(bankAccount);
        return  new JsonResult(1,"修改成功");
    }
    @RequestMapping("/addAccount.do")
    @ResponseBody
    public JsonResult addAccount (BankAccount bankAccount) {
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.setAccount(account);
//        bankAccount.setName(name);
//        bankAccount.setCreate_bank_name(create_bank_name);
//        bankAccount.setCreate_date(create_date);
//        bankAccount.setAddress_id(address_id);
//        bankAccount.setBalance(balance);
//        System.out.println("===================" + balance +"==========================");
        bankAccountService.addBankAccount(bankAccount);
        return new JsonResult(1, "添加成功");
    }

    @RequestMapping("/deleteAccountById.do")
    @ResponseBody
    public JsonResult deleteAccountById (Integer id) {
        System.out.println("=============================" + id);
        bankAccountService.deleteAccountById(id);
        return new JsonResult(1, "删除成功");
    }
    @RequestMapping("/deleteAccountByIds.do")
    @ResponseBody
    public JsonResult deleteAccountByIds (String aids) {
        int length = aids.length();
        String substring = aids.substring(1,length-1);
        String[] split = substring.split(",");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        bankAccountService.deleteAccountByIds(list);
        return  new JsonResult(1, "删除成功");
    }
}
