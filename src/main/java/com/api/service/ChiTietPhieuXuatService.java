package com.api.service;

import com.api.dao_impl.ChiTietPhieuXuatImpl;
import com.api.model.ChiTietDonHang;
import com.api.model.ChiTietPhieuXuat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class ChiTietPhieuXuatService implements ChiTietPhieuXuat_Service_Interface{
    @Autowired
    ChiTietPhieuXuatImpl chiTietPhieuXuatImpl;

    @Override
    public boolean Add(ChiTietPhieuXuat entity) {
        return chiTietPhieuXuatImpl.Add(entity);
    }

    @Override
    public boolean Delete(ChiTietPhieuXuat entity) {
        return chiTietPhieuXuatImpl.Delete(entity);
    }

    @Override
    public boolean Update(ChiTietPhieuXuat entity) {
        return chiTietPhieuXuatImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return chiTietPhieuXuatImpl.FinbyProperty(property,value);
    }

    @Override
    public List<ChiTietPhieuXuat> FindAll() {
        return chiTietPhieuXuatImpl.FindAll();
    }
}