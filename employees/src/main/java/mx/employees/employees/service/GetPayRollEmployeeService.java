package mx.employees.employees.service;

import mx.employees.employees.common.dto.GetPayRollEmployeeRequest;
import mx.employees.employees.common.dto.GetPayRollEmployeeResponse;

public interface GetPayRollEmployeeService {
    GetPayRollEmployeeResponse getPayRoll(GetPayRollEmployeeRequest request);
}
