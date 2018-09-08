package com.api.service;

import com.api.dao_impl.DonHangImpl;
import com.api.model.DonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class DonHangService implements  DonHang_Service_Interface{
    @Autowired
    DonHangImpl donHangImpl;

    @Override
    public boolean Add(DonHang entity) {
        return donHangImpl.Add(entity);
    }

    @Override
    public boolean Delete(DonHang entity) {
        return donHangImpl.Delete(entity);
    }

    @Override
    public boolean Update(DonHang entity) {
        return donHangImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return donHangImpl.FinbyProperty(property,value);
    }

    @Override
    public List<DonHang> FindAll() {
        return donHangImpl.FindAll();
    }
}