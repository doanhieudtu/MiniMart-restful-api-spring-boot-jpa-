package com.api.service;

import com.api.dao_impl.NhomNhaCCapImpl;
import com.api.model.NhomNhaCCap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
@Service
public class NhomNhaCCapService implements NhomNhaCCap_Service_Interface{
    @Autowired
    NhomNhaCCapImpl nhomNhaCCapimpl;

    @Override
    public boolean Add(NhomNhaCCap entity) {
        return nhomNhaCCapimpl.Add(entity);
    }

    @Override
    public boolean Delete(NhomNhaCCap entity) {
        return nhomNhaCCapimpl.Delete(entity);
    }

    @Override
    public boolean Update(NhomNhaCCap entity) {
        return nhomNhaCCapimpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return nhomNhaCCapimpl.FinbyProperty(property, value);
    }

    @Override
    public List<NhomNhaCCap> FindAll() {
        return nhomNhaCCapimpl.FindAll();
    }
}