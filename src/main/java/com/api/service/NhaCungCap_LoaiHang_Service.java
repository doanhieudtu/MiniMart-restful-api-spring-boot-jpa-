package com.api.service;

import com.api.dao_impl.NhaCC_LoaiHang_Impl;
import com.api.model.NhaCC_LoaiHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class NhaCungCap_LoaiHang_Service implements  NhaCC_LoaiHang_Service_Interface{
    @Autowired
    NhaCC_LoaiHang_Impl nhaCC_loaiHangImpl;

    @Override
    public boolean Add(NhaCC_LoaiHang entity) {
        return nhaCC_loaiHangImpl.Add(entity);
    }

    @Override
    public boolean Delete(NhaCC_LoaiHang entity) {
        return nhaCC_loaiHangImpl.Delete(entity);
    }

    @Override
    public boolean Update(NhaCC_LoaiHang entity) {
        return nhaCC_loaiHangImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return nhaCC_loaiHangImpl.FinbyProperty(property, value);
    }

    @Override
    public List<NhaCC_LoaiHang> FindAll() {
        return nhaCC_loaiHangImpl.FindAll();
    }
}