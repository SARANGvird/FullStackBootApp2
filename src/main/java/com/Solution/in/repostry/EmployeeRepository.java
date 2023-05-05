package com.Solution.in.repostry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Solution.in.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
