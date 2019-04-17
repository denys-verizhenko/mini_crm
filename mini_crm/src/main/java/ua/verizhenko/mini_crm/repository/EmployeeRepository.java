package ua.verizhenko.mini_crm.repository;

import org.springframework.data.orient.object.repository.OrientObjectRepository;
import ua.verizhenko.mini_crm.data.Employee;

public interface EmployeeRepository extends OrientObjectRepository<Employee> {

    Employee findByFirstName(String firstName);
}
