package mx.employees.employees.service;

import mx.employees.employees.common.dto.CreateEmployeeRequest;
import mx.employees.employees.common.dto.CreateEmployeeResponse;

public interface CreateEmployeeService {
    CreateEmployeeResponse create(CreateEmployeeRequest request);
}
