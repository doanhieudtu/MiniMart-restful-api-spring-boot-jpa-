package com.api.service;

import com.api.dao_impl.NhaCC_MatHang_Impl;
import com.api.model.NhaCC_LoaiHang;
import com.api.model.NhaCC_MatHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class NhaCungCap_MatHang_Service implements NhaCC_MatHang_Service_Interface {
    @Autowired
    NhaCC_MatHang_Impl nhaCC_matHang_Impl;

    @Override
    public boolean Add(NhaCC_MatHang entity) {
        return nhaCC_matHang_Impl.Add(entity);
    }

    @Override
    public boolean Delete(NhaCC_MatHang entity) {
        return nhaCC_matHang_Impl.Delete(entity);
    }

    @Override
    public boolean Update(NhaCC_MatHang entity) {
        return nhaCC_matHang_Impl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return nhaCC_matHang_Impl.FinbyProperty(property, value);
    }

    @Override
    public List<NhaCC_MatHang> FindAll() {
        return nhaCC_matHang_Impl.FindAll();
    }
}