package mx.employees.employees.common.dto;

public class GetPayRollEmployeeRequest {
    private int employeeId;
    private String startDate;
    private String endDate;

    public GetPayRollEmployeeRequest() {
    }

    public GetPayRollEmployeeRequest(int employeeId, String startDate, String endDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
