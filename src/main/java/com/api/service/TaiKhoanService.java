package com.api.service;

import com.api.dao_impl.TaiKhoanImpl;
import com.api.model.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class TaiKhoanService implements TaiKhoan_Service_Interface {
    @Autowired
    TaiKhoanImpl taiKhoanImpl;

    @Override
    public boolean Add(TaiKhoan entity) {
        return taiKhoanImpl.Add(entity);
    }

    @Override
    public boolean Delete(TaiKhoan entity) {
        return taiKhoanImpl.Delete(entity);
    }

    @Override
    public boolean Update(TaiKhoan entity) {
        return taiKhoanImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return taiKhoanImpl.FinbyProperty(property, value);
    }

    @Override
    public List<TaiKhoan> FindAll() {
        return taiKhoanImpl.FindAll();
    }
}