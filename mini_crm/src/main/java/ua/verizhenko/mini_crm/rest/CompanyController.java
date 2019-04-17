package ua.verizhenko.mini_crm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.verizhenko.mini_crm.data.Company;
import ua.verizhenko.mini_crm.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody Company company) {
        return companyService.save(company);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public List<Company> readAll() {
        return companyService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public Company readByFirstName(@PathVariable String name) {
        return companyService.getByName(name);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{name}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Company update(@RequestBody Company company, @PathVariable String name) {
        return companyService.updateByName(company, name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String name) {
        companyService.deleteByName(name);
    }
}
