package com.api.service;

import com.api.model.KhoHang_Hang;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */

public interface KhoHang_Hang_Service_Interface {
    boolean Add(KhoHang_Hang entity);
    boolean Delete(KhoHang_Hang entity);
    boolean Update(KhoHang_Hang entity);
    Object[] FinbyProperty(String property, Object value);
    List<KhoHang_Hang> FindAll();
}