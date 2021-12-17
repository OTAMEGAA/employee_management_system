package com.psl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psl.project.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
