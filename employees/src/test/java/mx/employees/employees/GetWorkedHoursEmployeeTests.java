package mx.employees.employees;

import mx.employees.employees.common.dto.GetWorkedHoursEmployeeRequest;
import mx.employees.employees.common.dto.GetWorkedHoursEmployeeResponse;
import mx.employees.employees.common.utils.DateUtils;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.entity.Gender;
import mx.employees.employees.persistence.entity.Job;
import mx.employees.employees.persistence.repository.EmployeeFunctionsRepository;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.service.GetWorkedHoursEmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GetWorkedHoursEmployeeTests {

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeFunctionsRepository employeeFunctionsRepository;

    @Autowired
    private GetWorkedHoursEmployeeService getWorkedHoursEmployeeService;

    @Test
    void employee_does_not_exist() {

        GetWorkedHoursEmployeeRequest request = new GetWorkedHoursEmployeeRequest(1, "2022-02-01", "2022-02-01");

        Mockito.when(this.employeeRepository.findById(request.getEmployeeId()))
                .thenReturn(Optional.empty());

        GetWorkedHoursEmployeeResponse response = this.getWorkedHoursEmployeeService.getWorkedHoursEmployee(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void start_date_gratter_than_end_date() {

        GetWorkedHoursEmployeeRequest request = new GetWorkedHoursEmployeeRequest(1, "2022-02-06", "2022-02-04");

        GetWorkedHoursEmployeeResponse response = this.getWorkedHoursEmployeeService.getWorkedHoursEmployee(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void get_worked_hours_by_employee() {

        GetWorkedHoursEmployeeRequest request = new GetWorkedHoursEmployeeRequest(1, "2022-02-01", "2022-02-03");

        Mockito.when(this.employeeRepository.findById(request.getEmployeeId()))
                .thenReturn(Optional.of(new Employee(1, new Gender(1, "NO GENDER"), new Job(1, "JAVA DEV", new BigDecimal(30000)), "Eduardo", "Zavala", new Date())));

        Mockito.when(this.employeeFunctionsRepository.getTotalWorkedHoursByEmployee(request.getEmployeeId(), DateUtils.parseToDate(request.getStartDate()).get(), DateUtils.parseToDate(request.getEndDate()).get()))
                .thenReturn(8);

        GetWorkedHoursEmployeeResponse response = this.getWorkedHoursEmployeeService.getWorkedHoursEmployee(request);

        assertThat(response.isSuccess()).isTrue();

    }

}
