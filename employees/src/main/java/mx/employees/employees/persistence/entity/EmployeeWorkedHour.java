package mx.employees.employees.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "employee_worked_hours", indexes = {
        @Index(name = "fk_EMPLOYEE_WORKED_HOURS_EMPLOYEES1_idx", columnList = "EMPLOYEE_ID")
})
@Entity
public class EmployeeWorkedHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @Column(name = "WORKED_HOURS", nullable = false)
    private Integer workedHours;

    @Column(name = "WORKED_DATE", nullable = false)
    private LocalDate workedDate;

    public EmployeeWorkedHour() {
    }

    public EmployeeWorkedHour(Integer id, Employee employee, Integer workedHours, LocalDate workedDate) {
        this.id = id;
        this.employee = employee;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
    }

    public LocalDate getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(LocalDate workedDate) {
        this.workedDate = workedDate;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}