package mx.employees.employees.common.dto;

import mx.employees.employees.persistence.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class GetEmployeesByJobResponse extends CommonResponse{

    private List<Employee> employees = new ArrayList<>();

    public GetEmployeesByJobResponse() {
    }

    public GetEmployeesByJobResponse(boolean success, List<Employee> employees) {
        super(success);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
