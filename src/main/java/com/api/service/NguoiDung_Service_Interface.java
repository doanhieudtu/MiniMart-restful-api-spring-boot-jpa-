package com.api.service;

import com.api.model.NguoiDung;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface NguoiDung_Service_Interface {
    boolean Add(NguoiDung entity);
    boolean Delete(NguoiDung entity);
    boolean Update(NguoiDung entity);
    Object[] FinbyProperty(String property, Object value);
    List<NguoiDung> FindAll();
}