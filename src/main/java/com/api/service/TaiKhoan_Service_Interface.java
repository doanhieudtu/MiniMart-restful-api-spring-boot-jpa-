package com.api.service;

import com.api.model.TaiKhoan;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface TaiKhoan_Service_Interface {
    boolean Add(TaiKhoan entity);
    boolean Delete(TaiKhoan entity);
    boolean Update(TaiKhoan entity);
    Object[] FinbyProperty(String property, Object value);
    List<TaiKhoan> FindAll();
}