package mx.employees.employees.service;

import mx.employees.employees.common.dto.GetEmployeesByJobRequest;
import mx.employees.employees.common.dto.GetEmployeesByJobResponse;

public interface GetEmployeesByJobService {
    GetEmployeesByJobResponse getByJob(GetEmployeesByJobRequest request);
}
