package ua.verizhenko.mini_crm.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.Version;
import java.util.List;

@JsonIgnoreProperties(value = {"handler"})
public class Company {

    @Id
    private String id;

    @Version
    @JsonIgnore
    private Long version;

    /**
     * Added to avoid a runtime error whereby the detachAll property is checked
     * for existence but not actually used.
     */
    private String detachAll;

    private String name;

    private List<Employee> employees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
