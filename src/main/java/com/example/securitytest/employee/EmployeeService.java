package com.example.securitytest.employee;

import com.example.securitytest.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;

    public void create(String username, String password) {
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(passwordEncoder.encode(password));
        employeeRepository.save(employee);
    }

    public Employee getEmployee(String username) {
        Optional<Employee> employee = employeeRepository.findByusername(username);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new DataNotFoundException("employee not found");
        }
    }
}
