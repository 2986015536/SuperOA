package entity;

import java.util.Date;

public class BankAccount {
    private Integer id;
    private String account;
    private String name;
    private String create_bank_name;
    private Date create_date;
    private Integer address_id;
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_bank_name() {
        return create_bank_name;
    }

    public void setCreate_bank_name(String create_bank_name) {
        this.create_bank_name = create_bank_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", create_bank_name='" + create_bank_name + '\'' +
                ", create_date=" + create_date +
                ", address_id=" + address_id +
                ", balance=" + balance +
                '}';
    }
}
