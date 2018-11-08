package com.api.service;

import com.api.dao_impl.MatHang_ChiNhanh_impl;
import com.api.dao_interface.MatHang_ChiNhanh_Dao;
import com.api.model.MatHang_ChiNhanh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/14/2018.
 */
@Service
public class MatHang_ChiNhanh_Service implements MatHang_ChiNhanh_Service_Interface{

    @Autowired
    MatHang_ChiNhanh_impl matHang_chiNhanh_impl;

    @Override
    public boolean Add(MatHang_ChiNhanh entity) {
        return matHang_chiNhanh_impl.Add(entity);
    }

    @Override
    public boolean Delete(MatHang_ChiNhanh entity) {
        return matHang_chiNhanh_impl.Delete(entity);
    }

    @Override
    public boolean Update(MatHang_ChiNhanh entity) {
        return matHang_chiNhanh_impl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return matHang_chiNhanh_impl.FinbyProperty(property, value);
    }

    @Override
    public List<MatHang_ChiNhanh> FindContentLike(int chiNhanh, String noiDung) {
        return matHang_chiNhanh_impl.FindContentLike(chiNhanh,noiDung);
    }

    @Override
    public List<MatHang_ChiNhanh> FindAll() {
        return matHang_chiNhanh_impl.FindAll();
    }

    @Override
    public List<MatHang_ChiNhanh> FindIdByOfBranch(int chiNhanh, int id) {
        return matHang_chiNhanh_impl.FindIdByOfBranch(chiNhanh,id);
    }
}