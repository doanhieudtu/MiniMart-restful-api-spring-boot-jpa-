package com.api.service;

import com.api.model.ChiTietPhieuXuat;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface ChiTietPhieuXuat_Service_Interface {
    boolean Add(ChiTietPhieuXuat entity);
    boolean Delete(ChiTietPhieuXuat entity);
    boolean Update(ChiTietPhieuXuat entity);
    Object[] FinbyProperty(String property, Object value);
    List<ChiTietPhieuXuat> FindAll();

}