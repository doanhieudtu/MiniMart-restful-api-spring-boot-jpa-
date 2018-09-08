package com.api.service;

import com.api.dao_impl.ThongBaoImpl;
import com.api.model.ThongBao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class ThongBaoService implements  ThongBao_Service_Interface{
    @Autowired
    ThongBaoImpl thongBaoImpl;

    @Override
    public boolean Add(ThongBao entity) {
        return thongBaoImpl.Add(entity);
    }

    @Override
    public boolean Delete(ThongBao entity) {
        return thongBaoImpl.Delete(entity);
    }

    @Override
    public boolean Update(ThongBao entity) {
        return thongBaoImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return thongBaoImpl.FinbyProperty(property, value);
    }

    @Override
    public List<ThongBao> FindAll() {
        return thongBaoImpl.FindAll();
    }
}