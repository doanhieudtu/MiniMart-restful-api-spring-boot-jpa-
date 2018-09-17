package com.api.service;

import com.api.model.NhomNhaCCap;

import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
public interface NhomNhaCCap_Service_Interface {
    boolean Add(NhomNhaCCap entity);
    boolean Delete(NhomNhaCCap entity);
    boolean Update(NhomNhaCCap entity);
    Object[] FinbyProperty(String property, Object value);
    List<NhomNhaCCap> FindAll();
}