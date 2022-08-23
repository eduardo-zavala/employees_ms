package mx.employees.employees.common.dto;

import java.util.ArrayList;
import java.util.List;

public class GetEmployeesByListRequest {

    private List<Integer> employeeId = new ArrayList<Integer>();

    public GetEmployeesByListRequest() {

    }

    public GetEmployeesByListRequest(List<Integer> employeeId) {
        this.employeeId = employeeId;
    }

    public List<Integer> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(List<Integer> employeeId) {
        this.employeeId = employeeId;
    }
}
