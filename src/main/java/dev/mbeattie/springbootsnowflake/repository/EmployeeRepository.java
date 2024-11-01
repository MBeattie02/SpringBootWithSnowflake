package dev.mbeattie.springbootsnowflake.repository;

import dev.mbeattie.springbootsnowflake.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
