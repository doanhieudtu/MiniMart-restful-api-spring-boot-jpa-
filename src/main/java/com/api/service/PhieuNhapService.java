package com.api.service;

import com.api.dao_impl.PhieuNhapImpl;
import com.api.model.PhieuNhap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class PhieuNhapService implements PhieuNhap_Service_Interface {
    @Autowired
    PhieuNhapImpl phieuNhapImpl;

    @Override
    public boolean Add(PhieuNhap entity) {
        return phieuNhapImpl.Add(entity);
    }

    @Override
    public boolean Delete(PhieuNhap entity) {
        return phieuNhapImpl.Delete(entity);
    }

    @Override
    public boolean Update(PhieuNhap entity) {
        return phieuNhapImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return phieuNhapImpl.FinbyProperty(property, value);
    }

    @Override
    public List<PhieuNhap> FindAll() {
        return phieuNhapImpl.FindAll();
    }
}