package mx.employees.employees.common.dto;

public class GetEmployeesByJobRequest {

    private int jobId;

    public GetEmployeesByJobRequest() {
    }

    public GetEmployeesByJobRequest(int jobId) {
        this.jobId = jobId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
