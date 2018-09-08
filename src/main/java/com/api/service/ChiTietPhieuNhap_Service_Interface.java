package com.api.service;

import com.api.dao_impl.ChiTietPhieuNhapImpl;
import com.api.model.ChiTietPhieuNhap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface ChiTietPhieuNhap_Service_Interface {
    boolean Add(ChiTietPhieuNhap entity);
    boolean Delete(ChiTietPhieuNhap entity);
    boolean Update(ChiTietPhieuNhap entity);
    Object[] FinbyProperty(String property, Object value);
    List<ChiTietPhieuNhap> FindAll();
}