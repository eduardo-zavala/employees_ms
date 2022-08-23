package mx.employees.employees;

import mx.employees.employees.common.dto.GetPayRollEmployeeRequest;
import mx.employees.employees.common.dto.GetPayRollEmployeeResponse;
import mx.employees.employees.common.dto.GetWorkedHoursEmployeeRequest;
import mx.employees.employees.common.dto.GetWorkedHoursEmployeeResponse;
import mx.employees.employees.common.utils.DateUtils;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.entity.Gender;
import mx.employees.employees.persistence.entity.Job;
import mx.employees.employees.persistence.repository.EmployeeFunctionsRepository;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.service.GetPayRollEmployeeService;
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
public class GetPayRollEmployeeTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeFunctionsRepository employeeFunctionsRepository;

    @Autowired
    private GetPayRollEmployeeService getPayRollEmployeeService;

    @Test
    void employee_does_not_exist() {

        GetPayRollEmployeeRequest request = new GetPayRollEmployeeRequest(1, "2022-02-01", "2022-02-01");

        Mockito.when(this.employeeRepository.findById(request.getEmployeeId()))
                .thenReturn(Optional.empty());

        GetPayRollEmployeeResponse response = this.getPayRollEmployeeService.getPayRoll(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void start_date_gratter_than_end_date() {

        GetPayRollEmployeeRequest request = new GetPayRollEmployeeRequest(1, "2022-02-06", "2022-02-04");

        GetPayRollEmployeeResponse response = this.getPayRollEmployeeService.getPayRoll(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void get_pay_roll_by_employee() {

        GetPayRollEmployeeRequest request = new GetPayRollEmployeeRequest(1, "2022-02-01", "2022-02-04");

        Mockito.when(this.employeeRepository.findById(request.getEmployeeId()))
                .thenReturn(Optional.of(new Employee(1, new Gender(1, "NO GENDER"), new Job(1, "JAVA DEV", new BigDecimal(30000)), "Eduardo", "Zavala", new Date())));

        Mockito.when(this.employeeFunctionsRepository.getPayRollByEmployee(request.getEmployeeId(), DateUtils.parseToDate(request.getStartDate()).get(), DateUtils.parseToDate(request.getEndDate()).get()))
                .thenReturn(new BigDecimal(3000));

        GetPayRollEmployeeResponse response = this.getPayRollEmployeeService.getPayRoll(request);

        assertThat(response.isSuccess()).isTrue();

    }

}
