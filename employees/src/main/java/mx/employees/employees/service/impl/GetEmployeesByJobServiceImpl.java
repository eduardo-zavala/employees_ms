package mx.employees.employees.service.impl;

import mx.employees.employees.common.dto.GetEmployeesByJobRequest;
import mx.employees.employees.common.dto.GetEmployeesByJobResponse;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.service.GetEmployeesByJobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class GetEmployeesByJobServiceImpl implements GetEmployeesByJobService {

    private static Logger log = LogManager.getLogger(GetEmployeesByJobServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public GetEmployeesByJobResponse getByJob(GetEmployeesByJobRequest request) {

        List<Employee> employees = this.employeeRepository.findByJobId(request.getJobId());

        Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee a, Employee b) {
                return a.getLastName().compareTo(b.getLastName());
            }

        });

        return new GetEmployeesByJobResponse(true, employees);
    }

}
