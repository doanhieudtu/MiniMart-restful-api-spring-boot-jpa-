package com.api.service;

import com.api.dao_interface.ChiNhanhDao;
import com.api.model.ChiNhanh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class ChiNhanhService implements ChiNhanh_Service_Interface {

    @Autowired
    ChiNhanhDao chiNhanhDao;

    @Override
    public boolean Add(ChiNhanh entity) {
        return chiNhanhDao.Add(entity);
    }

    @Override
    public boolean Delete(ChiNhanh entity) {
        return chiNhanhDao.Delete(entity);
    }
    @Override
    public boolean Update(ChiNhanh entity) {
        return chiNhanhDao.Update(entity);
    }
    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return chiNhanhDao.FinbyProperty(property, value);
    }

    @Override
    public List<ChiNhanh> FindAll() {
        return chiNhanhDao.FindAll();
    }
}