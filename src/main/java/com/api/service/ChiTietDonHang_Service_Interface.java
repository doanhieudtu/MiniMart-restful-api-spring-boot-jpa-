package com.api.service;

import com.api.model.ChiTietDonHang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface ChiTietDonHang_Service_Interface {
    boolean Add(ChiTietDonHang entity);
    boolean Delete(ChiTietDonHang entity);
    boolean Update(ChiTietDonHang entity);
    Object[] FinbyProperty(String property, Object value);
    List<ChiTietDonHang> FindAll();
}