package com.sahaya.sahayaservices.controller;

import com.sahaya.sahayaservices.EmployeeService;
import com.sahaya.sahayaservices.entity.Employee;
import com.sahaya.sahayaservices.models.AuthenticationRequest;
import com.sahaya.sahayaservices.models.AuthenticationResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Employee registerEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);

    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticationResponse authenticateEmployee(@RequestBody AuthenticationRequest authRequest) {
        return employeeService.authenticateUser(authRequest);
    }



}
