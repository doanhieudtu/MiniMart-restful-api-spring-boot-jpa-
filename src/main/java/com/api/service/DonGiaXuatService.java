package com.api.service;

import com.api.dao_impl.DonGiaXuatImpl;
import com.api.model.DonGiaXuat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
@Service
public class DonGiaXuatService implements DoanGiaXuat_Service_Interface{
    @Autowired
    DonGiaXuatImpl donGiaXuatImpl;

    @Override
    public boolean Add(DonGiaXuat entity) {
        return donGiaXuatImpl.Add(entity);
    }

    @Override
    public boolean Delete(DonGiaXuat entity) {
        return donGiaXuatImpl.Delete(entity);
    }

    @Override
    public boolean Update(DonGiaXuat entity) {
        return donGiaXuatImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return donGiaXuatImpl.FinbyProperty(property, value);
    }

    @Override
    public List<DonGiaXuat> FindAll() {
        return donGiaXuatImpl.FindAll();
    }
}