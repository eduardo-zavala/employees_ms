package mx.employees.employees.common.dto;

public class CreateEmployeeResponse extends CommonResponse{

    private int id;

    public CreateEmployeeResponse() {
    }

    public CreateEmployeeResponse(boolean success, int id) {
        super(success);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
