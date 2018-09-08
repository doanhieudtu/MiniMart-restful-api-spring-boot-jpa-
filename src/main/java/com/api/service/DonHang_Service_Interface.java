package com.api.service;

import com.api.model.DonHang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface DonHang_Service_Interface {
    boolean Add(DonHang entity);
    boolean Delete(DonHang entity);
    boolean Update(DonHang entity);
    Object[] FinbyProperty(String property, Object value);
    List<DonHang> FindAll();
}