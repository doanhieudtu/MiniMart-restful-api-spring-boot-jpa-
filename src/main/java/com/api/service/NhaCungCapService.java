package com.api.service;

import com.api.dao_impl.NhaCungCapImpl;
import com.api.model.NhaCungCap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class NhaCungCapService implements NhaCungCap_Service_Interface{
    @Autowired
    NhaCungCapImpl nhaCungCapImpl;

    @Override
    public boolean Add(NhaCungCap entity) {
        return nhaCungCapImpl.Add(entity);
    }

    @Override
    public boolean Delete(NhaCungCap entity) {
        return nhaCungCapImpl.Delete(entity);
    }

    @Override
    public boolean Update(NhaCungCap entity) {
        return nhaCungCapImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return nhaCungCapImpl.FinbyProperty(property, value);
    }

    @Override
    public List<NhaCungCap> FindAll() {
        return nhaCungCapImpl.FindAll();
    }
}