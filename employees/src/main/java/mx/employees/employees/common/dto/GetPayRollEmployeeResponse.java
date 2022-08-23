package mx.employees.employees.common.dto;

import java.math.BigDecimal;

public class GetPayRollEmployeeResponse extends CommonResponse{

    private BigDecimal payment;

    public GetPayRollEmployeeResponse() {
    }

    public GetPayRollEmployeeResponse(boolean success, BigDecimal payment) {
        super(success);
        this.payment = payment;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }
}
