package com.globallogic.test.dao;

import com.globallogic.test.dao.DAOImpl.InMemoryDaoImpl;
import com.globallogic.test.dao.interfaceDAO.CompanyDAO;

public class DAOInit {
    private static CompanyDAO DAO = new InMemoryDaoImpl();

//    public static void setDAO(CompanyDAO DAO) {
//        DAOInit.DAO = DAO;
//    }

    public static CompanyDAO getDAO() {
        return DAO;
    }
}
