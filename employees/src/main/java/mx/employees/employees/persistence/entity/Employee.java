package mx.employees.employees.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "employees", indexes = {
        @Index(name = "fk_EMPLOYEES_JOBS_idx", columnList = "JOB_ID"),
        @Index(name = "fk_EMPLOYEES_GENDERS1_idx", columnList = "GENDER_ID")
})
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "GENDER_ID", nullable = false)
    private Gender gender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "JOB_ID", nullable = false)
    private Job job;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTHDATE", nullable = false)
    private Date birthdate;

    public Employee() {
    }

    public Employee(Integer id, Gender gender, Job job, String name, String lastName, Date birthdate) {
        this.id = id;
        this.gender = gender;
        this.job = job;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}