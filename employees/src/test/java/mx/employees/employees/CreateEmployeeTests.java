package mx.employees.employees;

import mx.employees.employees.common.dto.CreateEmployeeRequest;
import mx.employees.employees.common.dto.CreateEmployeeResponse;
import mx.employees.employees.common.utils.DateUtils;
import mx.employees.employees.persistence.entity.Employee;
import mx.employees.employees.persistence.entity.Gender;
import mx.employees.employees.persistence.entity.Job;
import mx.employees.employees.persistence.repository.EmployeeRepository;
import mx.employees.employees.persistence.repository.GenderRepository;
import mx.employees.employees.persistence.repository.JobRepository;
import mx.employees.employees.service.CreateEmployeeService;
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
public class CreateEmployeeTests {

    @MockBean
    private JobRepository jobRepository;

    @MockBean
    private GenderRepository genderRepository;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private CreateEmployeeService createEmployeeService;

    @Test
    void employee_already_exist(){

        CreateEmployeeRequest request = new CreateEmployeeRequest(1, 1, "Eduardo", "Zavala", "1997-04-25");

        Mockito.when(this.employeeRepository.findByNameAndLastName(request.getName(), request.getLastName()))
            .thenReturn(Optional.of(new Employee(1, new Gender(1, "NO GENDER"), new Job(1, "JAVA DEV", new BigDecimal(30000)), "Eduardo", "Zavala", new Date())));

        CreateEmployeeResponse response = this.createEmployeeService.create(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void job_does_not_exist(){

        CreateEmployeeRequest request = new CreateEmployeeRequest(1, 1, "Eduardo", "Zavala", "1997-04-25");

        Mockito.when(this.jobRepository.findById(request.getJobId()))
                .thenReturn(Optional.empty());

        CreateEmployeeResponse response = this.createEmployeeService.create(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void gender_does_not_exist(){

        CreateEmployeeRequest request = new CreateEmployeeRequest(1, 1, "Eduardo", "Zavala", "1997-04-25");

        Mockito.when(this.jobRepository.findById(request.getJobId()))
                .thenReturn(Optional.of(new Job(1, "JAVA DEV", new BigDecimal(30000))));

        Mockito.when(this.genderRepository.findById(request.getGenderId()))
                .thenReturn(Optional.empty());

        CreateEmployeeResponse response = this.createEmployeeService.create(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void employee_is_not_adult(){

        CreateEmployeeRequest request = new CreateEmployeeRequest(1, 1, "Eduardo", "Zavala", "2024-04-25");

        Mockito.when(this.jobRepository.findById(request.getJobId()))
                .thenReturn(Optional.of(new Job(1, "JAVA DEV", new BigDecimal(30000))));

        Mockito.when(this.genderRepository.findById(request.getGenderId()))
                .thenReturn(Optional.of(new Gender(1, "NO GENDER")));

        CreateEmployeeResponse response = this.createEmployeeService.create(request);

        assertThat(response.isSuccess()).isFalse();

    }

    @Test
    void employee_create(){

        CreateEmployeeRequest request = new CreateEmployeeRequest(1, 1, "Eduardo", "Zavala", "1997-04-25");

        Mockito.when(this.jobRepository.findById(request.getJobId()))
                .thenReturn(Optional.of(new Job(1, "JAVA DEV", new BigDecimal(30000))));

        Mockito.when(this.genderRepository.findById(request.getGenderId()))
                .thenReturn(Optional.of(new Gender(1, "NO GENDER")));

        Mockito.when(this.employeeRepository.save(Mockito.any(Employee.class)))
                .thenReturn(new Employee(1, new Gender(request.getGenderId(), null), new Job(request.getJobId(), null, BigDecimal.ZERO), request.getName(), request.getLastName(), DateUtils.parseToDate(request.getBirthDate()).get()));

        CreateEmployeeResponse response = this.createEmployeeService.create(request);

        assertThat(response.isSuccess()).isTrue();

    }


}
