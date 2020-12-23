package service;

import entity.Employee;
import vo.EmployeeVO;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeVO> allEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void addEmployee(Employee employee);
    public void  deleteById(List list);
}
