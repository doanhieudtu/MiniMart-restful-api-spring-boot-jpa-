package com.api.service;

import com.api.dao_impl.DonGiaNhapImpl;
import com.api.dao_interface.DonGiaNhapDao;
import com.api.model.DonGiaNhap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DELL on 09/17/2018.
 */
@Service
public class DonGiaNhapService implements DonGiaNhap_Service_Interface{

    @Autowired
    DonGiaNhapImpl donGiaNhapimpl;

    @Override
    public boolean Add(DonGiaNhap entity) {
        return donGiaNhapimpl.Add(entity);
    }

    @Override
    public boolean Delete(DonGiaNhap entity) {
        return donGiaNhapimpl.Delete(entity);
    }

    @Override
    public boolean Update(DonGiaNhap entity) {
        return donGiaNhapimpl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return donGiaNhapimpl.FinbyProperty(property, value);
    }

    @Override
    public List<DonGiaNhap> FindAll() {
        return donGiaNhapimpl.FindAll();
    }

    @Override
    public DonGiaNhap FindByGetDate(String idProduct) {
        if(!idProduct.isEmpty()){
            DonGiaNhap donGiaNhap= donGiaNhapimpl.FindByGetDate(idProduct);
            if(donGiaNhap!= null) return donGiaNhap;
        }
        return null;
    }
}