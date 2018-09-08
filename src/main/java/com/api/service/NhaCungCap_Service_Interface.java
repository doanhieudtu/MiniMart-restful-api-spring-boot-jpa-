package com.api.service;

import com.api.model.NhaCungCap;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface NhaCungCap_Service_Interface {
    boolean Add(NhaCungCap entity);
    boolean Delete(NhaCungCap entity);
    boolean Update(NhaCungCap entity);
    Object[] FinbyProperty(String property, Object value);
    List<NhaCungCap> FindAll();
}