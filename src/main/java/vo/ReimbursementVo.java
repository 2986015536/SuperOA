package vo;

import java.util.Date;

public class ReimbursementVo {
    private Integer id;
    private String name;
    private double money;
    private Date date;
    private String status;
    private String ename;
    private String jname;
    private String dname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "ReimbursementVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", ename='" + ename + '\'' +
                ", jname='" + jname + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }
}
