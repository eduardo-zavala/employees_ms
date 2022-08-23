package mx.employees.employees.service.impl;

import mx.employees.employees.common.dto.GetWorkedHoursEmployeeRequest;
import mx.employees.employees.common.dto.GetWorkedHoursEmployeeResponse;
import mx.employees.employees.common.utils.DateUtils;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.repository.EmployeeFunctionsRepository;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.service.GetWorkedHoursEmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GetWorkedHoursEmployeeServiceImpl implements GetWorkedHoursEmployeeService {

    private static Logger log = LogManager.getLogger(GetWorkedHoursEmployeeServiceImpl.class);

    @Autowired
    private EmployeeFunctionsRepository employeeFunctionsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public GetWorkedHoursEmployeeResponse getWorkedHoursEmployee(GetWorkedHoursEmployeeRequest request){

        Optional<Employee> optionalEmployee = this.employeeRepository.findById(request.getEmployeeId());

        if (optionalEmployee.isEmpty()) {

            log.warn("The employee does not exist");
            return new GetWorkedHoursEmployeeResponse(false, 0);

        }

        Optional<Date> optionalStartDate = DateUtils.parseToDate(request.getStartDate());

        if (optionalStartDate.isEmpty()) {

            log.warn("The value of starDate is incorrect");
            return new GetWorkedHoursEmployeeResponse(false, 0);

        }

        Optional<Date> optionalEndDate = DateUtils.parseToDate(request.getEndDate());

        if (optionalEndDate.isEmpty()) {

            log.warn("The value of endDate is incorrect");
            return new GetWorkedHoursEmployeeResponse(false, 0);

        }

        if (!optionalEndDate.get().after(optionalStartDate.get())) {

            log.warn("The value of startDate is greatter than endDate");
            return new GetWorkedHoursEmployeeResponse(false, 0);

        }

        Integer workedHours = this.employeeFunctionsRepository.getTotalWorkedHoursByEmployee(request.getEmployeeId(), optionalStartDate.get(), optionalEndDate.get());

        return new GetWorkedHoursEmployeeResponse(true, workedHours);

    }

}
