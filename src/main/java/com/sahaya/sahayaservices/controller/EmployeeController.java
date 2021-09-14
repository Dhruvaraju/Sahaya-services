package com.sahaya.sahayaservices.controller;

import com.sahaya.sahayaservices.models.CommonResponse;
import com.sahaya.sahayaservices.models.EmployeeAdditionalDetails;
import com.sahaya.sahayaservices.service.EmployeeService;
import com.sahaya.sahayaservices.entity.Employee;
import com.sahaya.sahayaservices.models.AuthenticationRequest;
import com.sahaya.sahayaservices.models.AuthenticationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/user")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResponse registerEmployee(@RequestBody Employee employee) throws Exception{
        return employeeService.addEmployee(employee);

    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticationResponse authenticateEmployee(@RequestBody AuthenticationRequest authRequest) {
        return employeeService.authenticateUser(authRequest);
    }

    @RequestMapping(value = "/empId", method = RequestMethod.POST)
    public CommonResponse forgetEmployeeId(@RequestBody Employee userEmail) throws Exception {
        return employeeService.fetchEmployeeId((userEmail));
    }

    @RequestMapping(value = "/creds", method = RequestMethod.POST)
    public EmployeeAdditionalDetails forgetPassword(@RequestBody Employee userEmpId) throws Exception {
        return employeeService.fetchSecretQnA((userEmpId));
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST )
    public CommonResponse resetPassword(@RequestBody AuthenticationRequest authRequest) throws Exception {
        return employeeService.updatePassword((authRequest));
    }



}
