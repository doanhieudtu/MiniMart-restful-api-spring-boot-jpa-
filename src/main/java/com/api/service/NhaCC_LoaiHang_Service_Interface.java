package com.api.service;

import com.api.model.NhaCC_LoaiHang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface NhaCC_LoaiHang_Service_Interface {
    boolean Add(NhaCC_LoaiHang entity);
    boolean Delete(NhaCC_LoaiHang entity);
    boolean Update(NhaCC_LoaiHang entity);
    Object[] FinbyProperty(String property, Object value);
    List<NhaCC_LoaiHang> FindAll();
}