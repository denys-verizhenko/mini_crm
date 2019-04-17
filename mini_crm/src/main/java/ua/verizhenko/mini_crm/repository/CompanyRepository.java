package ua.verizhenko.mini_crm.repository;

import org.springframework.data.orient.object.repository.OrientObjectRepository;
import ua.verizhenko.mini_crm.data.Company;

public interface CompanyRepository extends OrientObjectRepository<Company> {

    Company findByName(String name);
}
