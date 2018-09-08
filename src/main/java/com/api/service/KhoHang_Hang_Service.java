package com.api.service;

import com.api.dao_impl.KhoHang_Hang_Impl;
import com.api.model.KhoHang_Hang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class KhoHang_Hang_Service implements  KhoHang_Hang_Service_Interface{
    @Autowired
    KhoHang_Hang_Impl khoHang_hang_Impl;

    @Override
    public boolean Add(KhoHang_Hang entity) {
        return khoHang_hang_Impl.Add(entity);
    }

    @Override
    public boolean Delete(KhoHang_Hang entity) {
        return khoHang_hang_Impl.Add(entity);
    }

    @Override
    public boolean Update(KhoHang_Hang entity) {
        return khoHang_hang_Impl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return khoHang_hang_Impl.FinbyProperty(property, value);
    }

    @Override
    public List<KhoHang_Hang> FindAll() {
        return khoHang_hang_Impl.FindAll();
    }
}