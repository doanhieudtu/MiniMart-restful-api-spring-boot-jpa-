package com.api.service;

import com.api.model.KhoHang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface KhoHang_Service_Interface {
    boolean Add(KhoHang entity);
    boolean Delete(KhoHang entity);
    boolean Update(KhoHang entity);
    Object[] FinbyProperty(String property, Object value);
    List<KhoHang> FindAll();
}