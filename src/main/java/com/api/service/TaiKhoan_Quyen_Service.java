package com.api.service;

import com.api.dao_impl.PhanQuyen_TK_Impl;
import com.api.model.TaiKhoan_Quyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class TaiKhoan_Quyen_Service implements  TK_Quyen_Service_Interface {
    @Autowired
    PhanQuyen_TK_Impl phanQuyen_tk_Impl;

    @Override
    public boolean Add(TaiKhoan_Quyen entity) {
        return phanQuyen_tk_Impl.Add(entity);
    }

    @Override
    public boolean Delete(TaiKhoan_Quyen entity) {
        return phanQuyen_tk_Impl.Delete(entity);
    }

    @Override
    public boolean Update(TaiKhoan_Quyen entity) {
        return phanQuyen_tk_Impl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return phanQuyen_tk_Impl.FinbyProperty(property, value);
    }

    @Override
    public List<TaiKhoan_Quyen> FindAll() {
        return phanQuyen_tk_Impl.FindAll();
    }
}