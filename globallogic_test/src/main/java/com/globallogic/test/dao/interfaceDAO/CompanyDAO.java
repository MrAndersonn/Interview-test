package com.globallogic.test.dao.interfaceDAO;

import com.globallogic.test.model.Company;

import java.util.List;

public interface CompanyDAO {

    void save(Company company);

    List<Company> getAllCompany();

}
