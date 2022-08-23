package mx.employees.employees.persistence.repository;

import mx.employees.employees.persistence.entity.EmployeeWorkedHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeWorkedHourRepository extends JpaRepository<EmployeeWorkedHour, Integer> {
}