package com.api.service;

import com.api.model.PhieuXuat;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */

public interface PhieuXuat_Service_Interface {
    boolean Add(PhieuXuat entity);
    boolean Delete(PhieuXuat entity);
    boolean Update(PhieuXuat entity);
    Object[] FinbyProperty(String property, Object value);
    List<PhieuXuat> FindAll();

}