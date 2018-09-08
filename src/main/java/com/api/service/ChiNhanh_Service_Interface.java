package com.api.service;

import com.api.model.ChiNhanh;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface ChiNhanh_Service_Interface {
    boolean Add(ChiNhanh entity);
    boolean Delete(ChiNhanh entity);
    boolean Update(ChiNhanh entity);
    Object[] FinbyProperty(String property, Object value);
    List<ChiNhanh> FindAll();
}