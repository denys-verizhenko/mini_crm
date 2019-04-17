package ua.verizhenko.mini_crm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.verizhenko.mini_crm.data.Employee;
import ua.verizhenko.mini_crm.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public List<Employee> readAll() {
        return employeeService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{firstName}")
    @ResponseStatus(HttpStatus.FOUND)
    public Employee readByFirstName(@PathVariable String firstName) {
        return employeeService.getByFirstName(firstName);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{firstName}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody Employee employee, @PathVariable String firstName) {
        return employeeService.updateByFirstName(employee, firstName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{firstName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String firstName) {
        employeeService.deleteByFirstName(firstName);
    }
}
