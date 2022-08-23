package mx.employees.employees.service.impl;

import mx.employees.employees.common.dto.GetEmployeesByListRequest;
import mx.employees.employees.common.dto.GetEmployeesByListResponse;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.service.GetEmployeesByListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GetEmployeesByListServiceImpl implements GetEmployeesByListService {

    private static Logger log = LogManager.getLogger(GetEmployeesByListServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public GetEmployeesByListResponse getByList(GetEmployeesByListRequest request) {

        try {

            return new GetEmployeesByListResponse(true, this.getEmployeesAsync(request.getEmployeeId()).get());

        } catch (Exception e) {

            log.error("Error getting the employee data by multi thread ", e);
            return new GetEmployeesByListResponse(false, null);

        }

    }

    private CompletableFuture<List<Employee>> getEmployeesAsync(List<Integer> employeeId) {


        CompletableFuture<List<Employee>> futureEmployees = CompletableFuture.supplyAsync(() -> {

            return employeeRepository.findByIdIn(employeeId);

        });

        return futureEmployees;

    }

}
