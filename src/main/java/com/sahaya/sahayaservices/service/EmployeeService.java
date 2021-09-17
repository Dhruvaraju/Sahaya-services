package com.sahaya.sahayaservices.service;

import com.sahaya.sahayaservices.entity.Employee;
import com.sahaya.sahayaservices.enums.EmployeeType;
import com.sahaya.sahayaservices.entity.Ticket;
import com.sahaya.sahayaservices.enums.Status;
import com.sahaya.sahayaservices.enums.TicketSeverity;
import com.sahaya.sahayaservices.enums.TicketStatus;
import com.sahaya.sahayaservices.models.AuthenticationRequest;
import com.sahaya.sahayaservices.models.AuthenticationResponse;
import com.sahaya.sahayaservices.models.CommonResponse;
import com.sahaya.sahayaservices.models.EmployeeAdditionalDetails;
import com.sahaya.sahayaservices.repository.EmployeeRepository;
import com.sahaya.sahayaservices.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;


    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public CommonResponse addEmployee(Employee user) throws Exception {
        Employee loEmployee = employeeRepo.findEmployeeByContactNoAndEmail(user.getContactNo(), user.getEmail());
        if (null == loEmployee) {
            Employee emp = employeeRepo.save(user);
            emp.setEmployeeId(500000 + emp.getId());
            emp.setWorkPoint(0L);
            if (null == emp.getEmployeeType()) {
                emp.setEmployeeType(EmployeeType.USER);
            }
            employeeRepo.save(emp);
            return new CommonResponse(Status.ADDED, "Generated Employee Id: " + emp.getEmployeeId().toString());
        } else {
            return new CommonResponse(Status.EXISTS, "User already present");
        }

    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest authRequest) {
        Employee loEmployee = employeeRepo.findEmployeeByEmployeeIdAndPassword((Long.parseLong(authRequest.getUserName())), authRequest.getPassword());
        if (null != loEmployee) {
            return new AuthenticationResponse(loEmployee.getEmployeeId().toString(), loEmployee.getName(), true, loEmployee.getEmployeeType(), loEmployee.getWorkPoint());
        } else {
            return new AuthenticationResponse(null, null, false, null, null);
        }
    }

    public CommonResponse fetchEmployeeId(Employee user) throws Exception {
        Employee loEmployee = employeeRepo.findEmployeeByEmail(user.getEmail());
        if (null != loEmployee) {
            return new CommonResponse(Status.FOUND, loEmployee.getEmployeeId().toString());
        } else {
            return new CommonResponse(Status.NOTFOUND, "User Unavailable");
        }
    }

    public EmployeeAdditionalDetails fetchSecretQnA(Employee user) {
        Employee loEmployee = employeeRepo.findEmployeeByEmployeeId(user.getEmployeeId());
        if (null != loEmployee) {
            return new EmployeeAdditionalDetails(loEmployee.getSecretQn1(), loEmployee.getSecretAn1(), loEmployee.getSecretQn2(), loEmployee.getSecretAn2());

        } else {
            return new EmployeeAdditionalDetails();
        }
    }



    public CommonResponse updateEmployeeDetails(Employee employee) throws Exception {
        Employee loemployee = employeeRepo.findEmployeeByEmployeeId(employee.getEmployeeId());
        if (null != loemployee) {
            if (null != employee.getPassword()) {
                loemployee.setPassword(employee.getPassword());
            }
            if (null != employee.getName()) {
                loemployee.setName(employee.getName());
            }
            if (null != employee.getContactNo()) {
                loemployee.setContactNo(employee.getContactNo());
            }
            if (null != employee.getSecretQn1()) {
                loemployee.setSecretQn1(employee.getSecretQn1());
            }
            if (null != employee.getSecretAn1()) {
                loemployee.setSecretAn1(employee.getSecretAn1());
            }
            if (null != employee.getSecretQn2()) {
                loemployee.setSecretQn2(employee.getSecretQn2());
            }
            if (null != employee.getSecretAn2()) {
                loemployee.setSecretAn2(employee.getSecretAn2());
            }
            employeeRepo.save(loemployee);
            return new CommonResponse(Status.UPDATED, " Details reset successfully");
        } else {
            return new CommonResponse(Status.NOTFOUND, "User not found");
        }
    }
}








