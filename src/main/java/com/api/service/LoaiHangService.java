package com.api.service;

import com.api.dao_impl.LoaiHangImpl;
import com.api.model.LoaiHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class LoaiHangService implements LoaiHang_Service_Interface {
    @Autowired
    LoaiHangImpl loaiHangImpl;

    @Override
    public boolean Add(LoaiHang entity) {
        return loaiHangImpl.Add(entity);
    }

    @Override
    public boolean Delete(LoaiHang entity) {
        return loaiHangImpl.Delete(entity);
    }

    @Override
    public boolean Update(LoaiHang entity) {
        return loaiHangImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return loaiHangImpl.FinbyProperty(property, value);
    }

    @Override
    public List<LoaiHang> FindAll() {
        return  loaiHangImpl.FindAll();
    }
}