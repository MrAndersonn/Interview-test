package com.globallogic.test.service;

import com.globallogic.test.dao.DAOInit;
import com.globallogic.test.dao.interfaceDAO.CompanyDAO;
import com.globallogic.test.model.AirCraft;
import com.globallogic.test.model.AirLineCompany;
import com.globallogic.test.model.Company;
import com.globallogic.test.service.action.Calculating;
import com.globallogic.test.service.action.Searching;

import java.util.ArrayList;
import java.util.List;

public class AirlineService implements Calculating {
    private CompanyDAO dao = DAOInit.getDAO();

    @Override
    public int calculateTotalCapacity() {
        List<AirLineCompany> companies =getAllAirCraftCompany();
        int result =0;
        for (AirLineCompany airLineCompany : companies) {
            for (int j = 0; j < airLineCompany.getTransports().size(); j++) {
                result += airLineCompany.getTransports().get(j).getCapacity();
            }
        }
        return result;
    }

    @Override
    public int calculateCarryingCapacity() {
        List<AirLineCompany> companies =getAllAirCraftCompany();
        int result =0;
        for (AirLineCompany airLineCompany : companies) {
            for (int j = 0; j < airLineCompany.getTransports().size(); j++) {
                result += airLineCompany.getTransports().get(j).getCarryingCapacity();
            }
        }
        return result;
    }

    public List<AirLineCompany> getAllAirCraftCompany(){
        List<AirLineCompany> airLineCompanies =new ArrayList<>();

        for (int i = 0; i < dao.getAllCompany().size(); i++) {
            if (dao.getAllCompany().get(i)instanceof AirLineCompany)
                airLineCompanies.add((AirLineCompany) dao.getAllCompany().get(i));
        }

        return airLineCompanies;
    }

    public List<AirCraft> getAllAirCraftOnAirLine(){
        List<AirCraft> airCrafts = new ArrayList<>();
        for (Company<AirCraft> airCraftCompany :
                getAllAirCraftCompany()) {
            airCrafts.addAll(airCraftCompany.getTransports());
        }

        return airCrafts;
    }



}
