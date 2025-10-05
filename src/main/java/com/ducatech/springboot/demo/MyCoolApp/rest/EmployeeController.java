package com.ducatech.springboot.demo.MyCoolApp.rest;

import com.ducatech.springboot.demo.MyCoolApp.entity.Employee;
import com.ducatech.springboot.demo.MyCoolApp.service.IEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private IEmployeeService employeeService;
    private ObjectMapper objectMapper;

    public EmployeeController() {
        System.out.print("Initializing Employee service ...");
    }

    @Autowired
    public EmployeeController(IEmployeeService employeeService, ObjectMapper theObjectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.findById(employeeId);

        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayload) {
        Optional<Employee> tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee.isEmpty())
            throw new RuntimeException("Employee id not found: " + employeeId);

        if (patchPayload.containsKey("id"))
            throw new RuntimeException("Employee id not allowed in request body: " + employeeId);

        Employee patchedEmployee = apply(patchPayload, tempEmployee.orElse(null));

        return employeeService.save(patchedEmployee);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/employees/{theId}")
    public void deleteById(@PathVariable int theId) {
        Optional<Employee> employee = employeeService.findById(theId);

        if (employee.isEmpty()) throw new RuntimeException("employee id does exist: " + theId);

        employeeService.deleteById(theId);
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
