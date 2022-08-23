package mx.employees.employees;


import mx.employees.employees.common.dto.GetEmployeesByListRequest;
import mx.employees.employees.common.dto.GetEmployeesByListResponse;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.entity.Gender;
import mx.employees.employees.persistence.entity.Job;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.service.GetEmployeesByJobService;
import mx.employees.employees.service.GetEmployeesByListService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GetEmployeesByListTests {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private GetEmployeesByListService getEmployeesByListService;

    @Test
    void get_list_by_list() {

        List<Integer> employeeId = new ArrayList<>();
        employeeId.add(1);
        employeeId.add(2);
        employeeId.add(3);

        Employee a = new Employee(1, new Gender(1, "GENDER"), new Job(1, "JOB", new BigDecimal(200)), "A", "A", new Date());
        Employee b = new Employee(2, new Gender(1, "GENDER"), new Job(1, "JOB", new BigDecimal(200)), "B", "B", new Date());
        Employee c = new Employee(3, new Gender(1, "GENDER"), new Job(1, "JOB", new BigDecimal(200)), "C", "C", new Date());

        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(c);
        mockEmployees.add(a);
        mockEmployees.add(b);

        GetEmployeesByListRequest  request = new GetEmployeesByListRequest(employeeId);

        Mockito.when(this.employeeRepository.findByIdIn(employeeId)).thenReturn(mockEmployees);

        GetEmployeesByListResponse response = this.getEmployeesByListService.getByList(request);

        assertThat(response.getEmployees()).isEqualTo(mockEmployees);

    }

}
