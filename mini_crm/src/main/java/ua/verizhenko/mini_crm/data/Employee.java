package ua.verizhenko.mini_crm.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.Version;

@JsonIgnoreProperties(value = {"handler"})
public class Employee {

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

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
