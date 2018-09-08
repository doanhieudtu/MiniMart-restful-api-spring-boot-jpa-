package com.api.service;

import com.api.model.NhaCC_MatHang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface NhaCC_MatHang_Service_Interface {
    boolean Add(NhaCC_MatHang entity);
    boolean Delete(NhaCC_MatHang entity);
    boolean Update(NhaCC_MatHang entity);
    Object[] FinbyProperty(String property, Object value);
    List<NhaCC_MatHang> FindAll();
}