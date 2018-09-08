package com.api.service;

import com.api.model.PhieuNhap;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface PhieuNhap_Service_Interface {
    boolean Add(PhieuNhap entity);
    boolean Delete(PhieuNhap entity);
    boolean Update(PhieuNhap entity);
    Object[] FinbyProperty(String property, Object value);
    List<PhieuNhap> FindAll();
}