package com.api.service;

import com.api.model.DonGiaXuat;

import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
public interface DoanGiaXuat_Service_Interface {
    boolean Add(DonGiaXuat entity);
    boolean Delete(DonGiaXuat entity);
    boolean Update(DonGiaXuat entity);
    Object[] FinbyProperty(String property, Object value);
    List<DonGiaXuat> FindAll();
}