package com.api.service;

import com.api.dao_impl.NguoiDungImpl;
import com.api.model.NguoiDung;
import org.omg.IOP.ENCODING_CDR_ENCAPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class NguoiDungService implements NguoiDung_Service_Interface{
    @Autowired
    NguoiDungImpl nguoiDungImpl;

    @Override
    public boolean Add(NguoiDung entity) {
        return nguoiDungImpl.Add(entity);
    }

    @Override
    public boolean Delete(NguoiDung entity) {
        return nguoiDungImpl.Delete(entity);
    }

    @Override
    public boolean Update(NguoiDung entity) {
        return nguoiDungImpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return nguoiDungImpl.FinbyProperty(property, value);
    }

    @Override
    public List<NguoiDung> FindAll() {
        return nguoiDungImpl.FindAll();
    }
}