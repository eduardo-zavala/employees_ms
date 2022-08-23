package mx.employees.employees;

import mx.employees.employees.common.dto.GetEmployeesByJobRequest;
import mx.employees.employees.common.dto.GetEmployeesByJobResponse;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.entity.Gender;
import mx.employees.employees.persistence.entity.Job;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.service.GetEmployeesByJobService;
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
public class GetEmployeesByJobTests {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private GetEmployeesByJobService getEmployeesByJobService;

    @Test
    void get_list_by_job_sort_by_last_name() {

        GetEmployeesByJobRequest request = new GetEmployeesByJobRequest(1);

        Employee c = new Employee(6, new Gender(1, "GENDER"), new Job(1, "JOB", new BigDecimal(200)), "C", "C", new Date());
        Employee a = new Employee(9, new Gender(1, "GENDER"), new Job(1, "JOB", new BigDecimal(200)), "A", "A", new Date());
        Employee b = new Employee(1, new Gender(1, "GENDER"), new Job(1, "JOB", new BigDecimal(200)), "B", "B", new Date());
        Employee z = new Employee(52, new Gender(1, "GENDER"), new Job(1, "JOB", new BigDecimal(200)), "Z", "Z", new Date());

        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(c);
        mockEmployees.add(a);
        mockEmployees.add(b);
        mockEmployees.add(z);

        List<Employee> mockEmployeesSortByLastName = new ArrayList<>();
        mockEmployeesSortByLastName.add(a);
        mockEmployeesSortByLastName.add(b);
        mockEmployeesSortByLastName.add(c);
        mockEmployeesSortByLastName.add(z);

        Mockito.when(this.employeeRepository.findByJobId(request.getJobId()))
            .thenReturn(mockEmployees);

        GetEmployeesByJobResponse response = this.getEmployeesByJobService.getByJob(request);

        assertThat(response.getEmployees()).isEqualTo(mockEmployeesSortByLastName);

    }

}
