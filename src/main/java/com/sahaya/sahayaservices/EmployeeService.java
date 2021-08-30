package com.sahaya.sahayaservices;

import com.sahaya.sahayaservices.entity.Employee;
import com.sahaya.sahayaservices.models.AuthenticationRequest;
import com.sahaya.sahayaservices.models.AuthenticationResponse;
import com.sahaya.sahayaservices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee user) {
        return employeeRepo.save(user);
    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest authRequest) {
        Employee loEmployee = employeeRepo.findEmployeeByEmployeeIdAndPassword((Long.parseLong(authRequest.getUserName())), authRequest.getPassword());
        if (null != loEmployee) {
            return new AuthenticationResponse(loEmployee.getEmployeeId().toString(), loEmployee.getName(), true, loEmployee.getEmployeeType());
        } else {
            return new AuthenticationResponse(null, null, false, null);
        }
    }
}
