package com.api.service;

import com.api.dao_impl.MatHangImpl;
import com.api.model.MatHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class MatHangService implements  MatHang_Service_Interface{
    @Autowired
    MatHangImpl matHangImpl;

    @Override
    public boolean Add(MatHang entity) {
        return matHangImpl.Add(entity);
    }

    @Override
    public boolean Delete(MatHang entity) {
        return matHangImpl.Delete(entity);
    }

    @Override
    public boolean Update(MatHang entity) {
        return matHangImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return matHangImpl.FinbyProperty(property, value);
    }

    @Override
    public List<MatHang> FindAll() {
        return matHangImpl.FindAll();
    }
}