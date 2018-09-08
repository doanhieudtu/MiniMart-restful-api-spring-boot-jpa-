package com.api.service;

import com.api.dao_impl.ChiTietPhieuNhapImpl;
import com.api.model.ChiTietDonHang;
import com.api.model.ChiTietPhieuNhap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class ChiTietPhieuNhapService implements ChiTietPhieuNhap_Service_Interface {
    @Autowired
    ChiTietPhieuNhapImpl chiTietPhieuNhapImpl;

    @Override
    public boolean Add(ChiTietPhieuNhap entity) {
        return chiTietPhieuNhapImpl.Add(entity);
    }

    @Override
    public boolean Delete(ChiTietPhieuNhap entity) {
        return chiTietPhieuNhapImpl.Delete(entity);
    }

    @Override
    public boolean Update(ChiTietPhieuNhap entity) {
        return chiTietPhieuNhapImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return chiTietPhieuNhapImpl.FinbyProperty(property,value);
    }

    @Override
    public List<ChiTietPhieuNhap> FindAll() {
        return chiTietPhieuNhapImpl.FindAll();
    }
}