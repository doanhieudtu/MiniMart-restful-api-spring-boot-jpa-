package com.api.service;

import com.api.model.MatHang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface MatHang_Service_Interface {
    boolean Add(MatHang entity);
    boolean Delete(MatHang entity);
    boolean Update(MatHang entity);
    Object[] FinbyProperty(String property, Object value);
    List<MatHang> FindAll();
}