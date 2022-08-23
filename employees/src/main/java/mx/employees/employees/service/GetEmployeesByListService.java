package mx.employees.employees.service;

import mx.employees.employees.common.dto.GetEmployeesByListRequest;
import mx.employees.employees.common.dto.GetEmployeesByListResponse;

public interface GetEmployeesByListService {
    GetEmployeesByListResponse getByList(GetEmployeesByListRequest request);
}
