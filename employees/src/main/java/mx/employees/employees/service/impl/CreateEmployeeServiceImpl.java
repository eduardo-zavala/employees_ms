package mx.employees.employees.service.impl;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class CreateEmployeeServiceImpl implements CreateEmployeeService {

    private static Logger log = LogManager.getLogger(CreateEmployeeServiceImpl.class);

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest request) {

        if (this.existEmployee(request.getName(), request.getLastName())) {

            log.warn("The employee :" + request.getName() + " " + request.getLastName() + " already exist.");
            return new CreateEmployeeResponse(false, 0);

        }

        Optional<Date> optionalBirthdate = DateUtils.parseToDate(request.getBirthDate());

        if (optionalBirthdate.isEmpty()) {

            log.warn("Error parsing the given date");
            return new CreateEmployeeResponse(false, 0);

        }

        if (!DateUtils.isAdult(optionalBirthdate.get())) {

            log.warn("The given employee is not adult");
            return new CreateEmployeeResponse(false, 0);

        }

        if (!this.existJob(request.getJobId())) {

            log.warn("The given job does not exist");
            return new CreateEmployeeResponse(false, 0);

        }

        if (!this.existGender(request.getGenderId())) {

            log.warn("The given gender does not exist");
            return new CreateEmployeeResponse(false, 0);

        }

        Optional<Employee> optionalEmployee = this.save(new Employee(null, new Gender(request.getGenderId(), null), new Job(request.getJobId(), null, BigDecimal.ZERO), request.getName(), request.getLastName(), optionalBirthdate.get()));

        if (optionalEmployee.isEmpty()) {

            log.error("Error saving the employee");
            return new CreateEmployeeResponse(false, 0);
        }

        return new CreateEmployeeResponse(true, optionalEmployee.get().getId());

    }

    private boolean existEmployee(String name, String lastName) {

        if (this.employeeRepository.findByNameAndLastName(name, lastName).isPresent()) {

            return true;

        }

        return false;

    }

    private boolean existJob(int id) {

        if (this.jobRepository.findById(id).isPresent()) {

            return true;

        }

        return false;

    }

    private boolean existGender(int id) {

        if (this.genderRepository.findById(id).isPresent()) {

            return true;

        }

        return false;

    }

    private Optional<Employee> save(Employee employee) {

        try {

            return Optional.of(this.employeeRepository.save(employee));

        } catch (Exception e) {

            log.error("Error saving data ", e);
            return Optional.empty();

        }

    }

}
