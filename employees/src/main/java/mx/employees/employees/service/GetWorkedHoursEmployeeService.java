package mx.employees.employees.service;

import mx.employees.employees.common.dto.GetWorkedHoursEmployeeRequest;
import mx.employees.employees.common.dto.GetWorkedHoursEmployeeResponse;

public interface GetWorkedHoursEmployeeService {
    GetWorkedHoursEmployeeResponse getWorkedHoursEmployee(GetWorkedHoursEmployeeRequest request);
}
