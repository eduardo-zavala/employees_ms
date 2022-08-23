package mx.employees.employees.common.dto;

public class CommonResponse {

    private boolean success;

    public CommonResponse() {
    }

    public CommonResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
