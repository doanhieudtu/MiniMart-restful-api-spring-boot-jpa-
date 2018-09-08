package com.api.service;

import com.api.dao_interface.ChiTietDonHangDao;
import com.api.model.ChiTietDonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class ChiTietDonHangService implements ChiTietDonHang_Service_Interface{
    @Autowired
    ChiTietDonHangDao chiTietDonHangDao;

    @Override
    public boolean Add(ChiTietDonHang entity) {
        return chiTietDonHangDao.Add(entity);
    }

    @Override
    public boolean Delete(ChiTietDonHang entity) {
        return chiTietDonHangDao.Delete(entity);
    }

    @Override
    public boolean Update(ChiTietDonHang entity) {
        return chiTietDonHangDao.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return chiTietDonHangDao.FinbyProperty(property, value);
    }

    @Override
    public List<ChiTietDonHang> FindAll() {
        return chiTietDonHangDao.FindAll();
    }
}