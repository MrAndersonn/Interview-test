package com.globallogic.test.model;

import java.util.List;

public abstract class Company<T extends Transport> {
    private String name;

    private List<T> transports;

    public Company(String name, List<T> transports) {
        this.name = name;
        this.transports = transports;
    }

    public Company(List<T> transports) {
        name=null;
        this.transports = transports;
    }

    public List<T> getTransports() {
        return transports;
    }

    public void addTransport(T transport) {
        transports.add(transport);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
