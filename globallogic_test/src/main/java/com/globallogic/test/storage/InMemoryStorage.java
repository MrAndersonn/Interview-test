package com.globallogic.test.storage;

import com.globallogic.test.model.Company;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {

    private List<Company> companies = new ArrayList<>();

    public  void addCompany(Company company){
        companies.add(company);
    }

    public  List<Company> getCompanies() {
        return companies;
    }
}
