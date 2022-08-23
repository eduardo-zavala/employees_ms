package mx.employees.employees.persistence.repository;

import mx.employees.employees.persistence.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
}