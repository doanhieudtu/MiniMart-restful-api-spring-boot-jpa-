package com.api.service;

import com.api.dao_impl.DonGiaNhapImpl;
import com.api.dao_interface.DonGiaNhapDao;
import com.api.model.DonGiaNhap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
@Service
public class DonGiaNhapService implements DonGiaNhapDao{

    @Autowired
    DonGiaNhapImpl donGiaNhapimpl;

    @Override
    public boolean Add(DonGiaNhap entity) {
        return donGiaNhapimpl.Add(entity);
    }

    @Override
    public boolean Delete(DonGiaNhap entity) {
        return donGiaNhapimpl.Delete(entity);
    }

    @Override
    public boolean Update(DonGiaNhap entity) {
        return donGiaNhapimpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return donGiaNhapimpl.FinbyProperty(property, value);
    }

    @Override
    public List<DonGiaNhap> FindAll() {
        return donGiaNhapimpl.FindAll();
    }
}