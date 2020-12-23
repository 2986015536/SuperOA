package vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class DeptVO {
    @ColumnWidth(10)
    @ExcelProperty(value = { "部门ID" }, index = 0)
    @ContentStyle(horizontalAlignment =  HorizontalAlignment.CENTER)
    private Integer id;

    @ColumnWidth(15)
    @ExcelProperty(value = { "部门名" }, index = 1)
    @ContentStyle(horizontalAlignment =  HorizontalAlignment.CENTER)
    private String dname;

    @ColumnWidth(255)
    @ExcelProperty(value = { "部门简介" }, index = 2)
    private String remark;

    @ColumnWidth(100)
    @ContentStyle(horizontalAlignment =  HorizontalAlignment.CENTER)
    @ExcelProperty(value = { "部门人员" }, index = 3)
    private String eNames;

    @ColumnWidth(8)
    @ContentStyle(horizontalAlignment =  HorizontalAlignment.CENTER)
    @ExcelProperty(value = { "部门人数" }, index = 4)
    private Integer count;



    public DeptVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String geteNames() {
        return eNames;
    }

    public void seteNames(String eNames) {
        this.eNames = eNames;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DeptVO{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", remark='" + remark + '\'' +
                ", eNames='" + eNames + '\'' +
                ", count=" + count +
                '}';
    }
}
