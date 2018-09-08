package com.api.service;

import com.api.dao_impl.KhoHangImpl;
import com.api.model.DonHang;
import com.api.model.KhoHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class KhoHangService implements KhoHang_Service_Interface {
    @Autowired
    KhoHangImpl khoHangImpl;

    @Override
    public boolean Add(KhoHang entity) {
        return khoHangImpl.Add(entity);
    }

    @Override
    public boolean Delete(KhoHang entity) {
        return khoHangImpl.Delete(entity);
    }

    @Override
    public boolean Update(KhoHang entity) {
        return khoHangImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return khoHangImpl.FinbyProperty(property, value);
    }

    @Override
    public List<KhoHang> FindAll() {
        return khoHangImpl.FindAll();
    }
}