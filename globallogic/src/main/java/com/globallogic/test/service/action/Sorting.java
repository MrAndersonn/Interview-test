package com.globallogic.test.service.action;

import com.globallogic.test.model.Transport;

import java.util.List;

public interface Sorting<T extends Transport> {
    List<T> sort(List<T> entities);
}
