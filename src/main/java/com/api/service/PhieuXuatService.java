package com.api.service;

import com.api.dao_impl.PhieuXuatImpl;
import com.api.model.PhieuXuat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class PhieuXuatService implements PhieuXuat_Service_Interface  {
    @Autowired
    PhieuXuatImpl phieuXuatImpl;

    @Override
    public boolean Add(PhieuXuat entity) {
        return phieuXuatImpl.Add(entity);
    }

    @Override
    public boolean Delete(PhieuXuat entity) {
        return phieuXuatImpl.Delete(entity);
    }

    @Override
    public boolean Update(PhieuXuat entity) {
        return phieuXuatImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return phieuXuatImpl.FinbyProperty(property, value);
    }

    @Override
    public List<PhieuXuat> FindAll() {
        return phieuXuatImpl.FindAll();
    }
}