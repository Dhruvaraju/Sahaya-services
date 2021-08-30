package com.sahaya.sahayaservices.repository;

import com.sahaya.sahayaservices.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmployeeIdAndPassword(Long empId, String pwd);
    Employee findEmployeeByContactNoAndEmail(Long contactNo, String email);
}
