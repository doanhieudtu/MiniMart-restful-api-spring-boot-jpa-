package com.api.service;

import com.api.model.LoaiHang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface LoaiHang_Service_Interface {
    boolean Add(LoaiHang entity);
    boolean Delete(LoaiHang entity);
    boolean Update(LoaiHang entity);
    Object[] FinbyProperty(String property, Object value);
    List<LoaiHang> FindAll();
}