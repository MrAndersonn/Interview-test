package com.globallogic.test.service.action;

import com.globallogic.test.model.Company;
import com.globallogic.test.model.Transport;

import java.util.List;

public interface Searching<T extends Transport> {
    List<T> find(List<T> airCrafts);
}
