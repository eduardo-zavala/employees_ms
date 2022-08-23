package mx.employees.employees.common.dto;

public class GetWorkedHoursEmployeeResponse extends CommonResponse{

    private Integer totalWorkedHours;

    public GetWorkedHoursEmployeeResponse() {
    }

    public GetWorkedHoursEmployeeResponse(boolean success, Integer totalWorkedHours) {
        super(success);
        this.totalWorkedHours = totalWorkedHours;
    }

    public Integer getTotalWorkedHours() {
        return totalWorkedHours;
    }

    public void setTotalWorkedHours(Integer totalWorkedHours) {
        this.totalWorkedHours = totalWorkedHours;
    }
}
