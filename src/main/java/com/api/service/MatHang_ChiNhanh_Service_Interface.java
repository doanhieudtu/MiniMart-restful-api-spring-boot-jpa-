package com.api.service;

import com.api.model.MatHang_ChiNhanh;

import java.util.List;

/**
 * Created by DELL on 09/14/2018.
 */
public interface MatHang_ChiNhanh_Service_Interface {
    boolean Add(MatHang_ChiNhanh entity);
    boolean Delete(MatHang_ChiNhanh entity);
    boolean Update(MatHang_ChiNhanh entity);
    Object[] FinbyProperty(String property, Object value);
    List<MatHang_ChiNhanh> FindAll();
}