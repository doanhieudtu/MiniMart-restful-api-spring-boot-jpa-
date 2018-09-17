package com.api.service;

import com.api.model.DonGiaNhap;

import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
public interface DonGiaNhap_Service_Interface {
    boolean Add(DonGiaNhap entity);
    boolean Delete(DonGiaNhap entity);
    boolean Update(DonGiaNhap entity);
    Object[] FinbyProperty(String property, Object value);
    List<DonGiaNhap> FindAll();
}