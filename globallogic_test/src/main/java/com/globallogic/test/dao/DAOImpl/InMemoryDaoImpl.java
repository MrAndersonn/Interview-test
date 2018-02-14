package com.globallogic.test.dao.DAOImpl;

import com.globallogic.test.dao.interfaceDAO.CompanyDAO;
import com.globallogic.test.storage.InMemoryStorage;
import com.globallogic.test.model.Company;

import java.util.List;

public class InMemoryDaoImpl implements CompanyDAO {
    private InMemoryStorage storage = new InMemoryStorage();

    @Override
    public void save(Company company) {
        storage.addCompany(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return storage.getCompanies();
    }
}
