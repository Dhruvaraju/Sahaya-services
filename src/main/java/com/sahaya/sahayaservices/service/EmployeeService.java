package com.sahaya.sahayaservices.service;

import com.sahaya.sahayaservices.entity.Employee;
import com.sahaya.sahayaservices.enums.Status;
import com.sahaya.sahayaservices.models.AuthenticationRequest;
import com.sahaya.sahayaservices.models.AuthenticationResponse;
import com.sahaya.sahayaservices.models.CommonResponse;
import com.sahaya.sahayaservices.models.EmployeeAdditionalDetails;
import com.sahaya.sahayaservices.repository.EmployeeRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee user) throws Exception {
        Employee loEmployee = employeeRepo.findEmployeeByContactNoAndEmail(user.getContactNo(), user.getEmail());
        if (null == loEmployee) {
            return employeeRepo.save(user);
        }
        else
        {
            throw new Exception("user exists");
        }

    }

//    public CommonResponse addEmployee(Employee user) {
//        if(null != user.getEmail()){
//            Employee availableEmp = employeeRepo.findEmployeeByEmail(user.getEmail());
//            if(null != availableEmp){
//                return new CommonResponse(Status.EXISTS.toString(), "Employee already exists");
//            } else {
//                Employee loEmp = null;
//                long generatedEmpId = 0;
//                while (null == loEmp){
//                    generatedEmpId = (long) Math.random();
//                    loEmp = employeeRepo.findEmployeeByEmployeeId(generatedEmpId);
//                }
//                user.setEmployeeId(generatedEmpId);
//                employeeRepo.save(user);
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }


    public AuthenticationResponse authenticateUser(AuthenticationRequest authRequest) {
        Employee loEmployee = employeeRepo.findEmployeeByEmployeeIdAndPassword((Long.parseLong(authRequest.getUserName())), authRequest.getPassword());
        if (null != loEmployee) {
            return new AuthenticationResponse(loEmployee.getEmployeeId().toString(), loEmployee.getName(), true, loEmployee.getEmployeeType());
        } else {
            return new AuthenticationResponse(null, null, false, null);
        }
    }


        public CommonResponse fetchEmployeeId (Employee user) throws Exception {
            Employee loEmployee = employeeRepo.findEmployeeByEmail(user.getEmail());
            if (null != loEmployee) {
                return new CommonResponse(Status.FOUND, loEmployee.getEmployeeId().toString());
            } else {
                return new CommonResponse(Status.NOTFOUND, "User Unavailable");
            }
    }

    public EmployeeAdditionalDetails fetchSecretQnA (Employee user)  {
        Employee loEmployee = employeeRepo.findEmployeeByEmployeeId(user.getEmployeeId());
        if (null != loEmployee) {
            return new EmployeeAdditionalDetails(loEmployee.getSecretQn1(), loEmployee.getSecretAn1(), loEmployee.getSecretQn2(), loEmployee.getSecretAn2());

        } else {
            return new EmployeeAdditionalDetails();
        }
    }

    public CommonResponse updatePassword (AuthenticationRequest authRequest) throws Exception{
        Employee loEmployee = employeeRepo.findEmployeeByEmployeeId((Long.parseLong(authRequest.getUserName())));
        if (null != loEmployee) {
            loEmployee.setPassword(authRequest.getPassword());
            employeeRepo.save(loEmployee);
            return new CommonResponse(Status.UPDATED,"Password reset successfully");
        }
        else
        {
            return new CommonResponse(Status.NOTFOUND,"User not found");
        }
    }
}
