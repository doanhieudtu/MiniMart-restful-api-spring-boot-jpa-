package com.api.service;

import com.api.model.TaiKhoan_Quyen;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface TK_Quyen_Service_Interface {
    boolean Add(TaiKhoan_Quyen entity);
    boolean Delete(TaiKhoan_Quyen entity);
    boolean Update(TaiKhoan_Quyen entity);
    Object[] FinbyProperty(String property, Object value);
    List<TaiKhoan_Quyen> FindAll();
}