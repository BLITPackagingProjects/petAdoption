package com.blit.petAdoption.Repository;

import com.blit.petAdoption.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
