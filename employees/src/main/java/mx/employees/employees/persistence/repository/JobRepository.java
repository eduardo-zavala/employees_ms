package mx.employees.employees.persistence.repository;

import mx.employees.employees.persistence.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}