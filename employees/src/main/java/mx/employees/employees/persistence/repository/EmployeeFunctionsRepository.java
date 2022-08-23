package mx.employees.employees.persistence.repository;

import mx.employees.employees.persistence.entity.Functions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Date;

public interface EmployeeFunctionsRepository extends CrudRepository<Functions, Long> {

    @Query(value = "SELECT get_total_worked_hours_by_employee(?1, ?2, ?3)", nativeQuery = true)
    public Integer getTotalWorkedHoursByEmployee(int employeeId, Date startDate, Date endDate);

    @Query(value = "SELECT get_pay_roll_by_employee(?1, ?2, ?3)", nativeQuery = true)
    public BigDecimal getPayRollByEmployee(int employeeId, Date startDate, Date endDate);

}
