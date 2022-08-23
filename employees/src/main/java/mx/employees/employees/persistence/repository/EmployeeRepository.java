package mx.employees.employees.persistence.repository;

import mx.employees.employees.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByNameAndLastName(String name, String lastName);

    List<Employee> findByJobId(int jobId);

    List<Employee> findByIdIn(List<Integer> ids);
}