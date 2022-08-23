package mx.employees.employees.common.dto;

public class CreateEmployeeRequest {

    private int genderId;
    private int jobId;
    private String name;
    private String lastName;
    private String birthDate;

    public CreateEmployeeRequest() {
    }

    public CreateEmployeeRequest(int genderId, int jobId, String name, String lastName, String birthDate) {
        this.genderId = genderId;
        this.jobId = jobId;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
