package com.api.service;

import com.api.dao_impl.PhanQuyenImpl;
import com.api.model.PhanQuyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class PhanQuyenService implements PhanQuyen_Service_Interface {
    @Autowired
    PhanQuyenImpl phanQuyenImpl;

    @Override
    public boolean Add(PhanQuyen entity) {
        return phanQuyenImpl.Add(entity);
    }

    @Override
    public boolean Delete(PhanQuyen entity) {
        return phanQuyenImpl.Delete(entity);
    }

    @Override
    public boolean Update(PhanQuyen entity) {
        return phanQuyenImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return phanQuyenImpl.FinbyProperty(property, value);
    }

    @Override
    public List<PhanQuyen> FindAll() {
        return phanQuyenImpl.FindAll();
    }
}