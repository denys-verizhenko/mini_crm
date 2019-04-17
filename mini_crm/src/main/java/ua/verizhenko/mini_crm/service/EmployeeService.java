package ua.verizhenko.mini_crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.verizhenko.mini_crm.data.Employee;
import ua.verizhenko.mini_crm.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateByFirstName(Employee updatedEmployee, String firstName) {
        Employee oldEmployee = employeeRepository.findByFirstName(firstName);
        updatedEmployee.setId(oldEmployee.getId());
        return employeeRepository.save(updatedEmployee);
    }

    public void deleteByFirstName(String firstName) {
        Employee employee = employeeRepository.findByFirstName(firstName);
        employeeRepository.delete(employee);
    }
}
