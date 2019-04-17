package ua.verizhenko.mini_crm;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.verizhenko.mini_crm.data.Company;
import ua.verizhenko.mini_crm.data.Employee;
import ua.verizhenko.mini_crm.repository.CompanyRepository;
import ua.verizhenko.mini_crm.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("ua.verizhenko.mini_crm")
@EnableOrientRepositories("ua.verizhenko.mini_crm.repository")
public class MiniCRMApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private OrientObjectDatabaseFactory factory;

    public static void main(String[] args) {
        SpringApplication.run(MiniCRMApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        OObjectDatabaseTx db = null;

        try {
            db = factory.openDatabase();
            db.getEntityManager().registerEntityClass(Employee.class);
        } finally {
            if (db != null) {
                db.close();
            }
        }

        //Create Persons if required
        if (repository.count() < 1) {
            List<Employee> employees = new ArrayList<>();

            Employee graham = new Employee();
            graham.setFirstName("Graham");
            graham.setLastName("Jacobson");
            graham.setEmail("graham@email.com");
            graham.setPhone("+123456789012");

            employees.add(graham);

            Employee ebony = new Employee();
            ebony.setFirstName("Ebony");
            ebony.setLastName("Irwin");
            ebony.setEmail("eboney@email.com");
            ebony.setPhone("+234567890123");

            employees.add(ebony);

            Employee benedict = new Employee();
            benedict.setFirstName("Benedict123");
            benedict.setLastName("Preston");
            benedict.setEmail("benedict@email.com");
            benedict.setPhone("+345678901234");

            employees.add(benedict);

            Company company = new Company();
            company.setName("company1");
            company.setEmployees(employees);

            companyRepository.save(company);
        }
    }
}
