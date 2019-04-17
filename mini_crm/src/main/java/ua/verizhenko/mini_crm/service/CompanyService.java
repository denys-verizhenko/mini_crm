package ua.verizhenko.mini_crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.verizhenko.mini_crm.data.Company;
import ua.verizhenko.mini_crm.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getByName(String name) {
        return companyRepository.findByName(name);
    }

    public Company updateByName(Company updatedCompany, String name) {
        Company oldCompany = companyRepository.findByName(name);
        updatedCompany.setId(oldCompany.getId());
        return companyRepository.save(updatedCompany);
    }

    public void deleteByName(String name) {
        Company company = companyRepository.findByName(name);
        companyRepository.delete(company);
    }
}
