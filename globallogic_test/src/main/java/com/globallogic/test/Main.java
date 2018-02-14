package com.globallogic.test;

import com.globallogic.test.cmd.CommandListener;
import com.globallogic.test.dao.DAOInit;
import com.globallogic.test.dao.interfaceDAO.CompanyDAO;
import com.globallogic.test.model.AirCraft;
import com.globallogic.test.model.AirLineCompany;
import com.globallogic.test.model.Company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        simulateData();
        CommandListener commandListener = new CommandListener();
        commandListener.launch();
    }

    private static void simulateData(){
        CompanyDAO companyDAO = DAOInit.getDAO();
        for (int i = 0; i < 4  ; i++) {
            List<AirCraft> airCrafts = new ArrayList<>();
            for (int j = 0; j < Math.random()*40; j++) {
                AirCraft airCraft = new AirCraft((int) (Math.random()*100),(int) (Math.random()*100),(int) (Math.random()*100),(int) (Math.random()*100));
                airCrafts.add(airCraft);
            }
            Company airCraftCompany =new AirLineCompany("Company : "+i,airCrafts);
            companyDAO.save(airCraftCompany);
        }

    }
}
