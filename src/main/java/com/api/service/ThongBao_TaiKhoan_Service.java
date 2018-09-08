package com.api.service;

import com.api.dao_impl.ThongBao_TK_Impl;
import com.api.model.ThongBao_TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
@Service
public class ThongBao_TaiKhoan_Service implements  TB_TaiKhoan_Service_Interface{
    @Autowired
    ThongBao_TK_Impl thongBao_tk_Impl;

    @Override
    public boolean Add(ThongBao_TaiKhoan entity) {
        return thongBao_tk_Impl.Add(entity);
    }

    @Override
    public boolean Delete(ThongBao_TaiKhoan entity) {
        return thongBao_tk_Impl.Delete(entity);
    }

    @Override
    public boolean Update(ThongBao_TaiKhoan entity) {
        return thongBao_tk_Impl.Update(entity);
    }

    @Override
    public Object[] FinbyProperty(String property, Object value) {
        return thongBao_tk_Impl.FinbyProperty(property, value);
    }

    @Override
    public List<ThongBao_TaiKhoan> FindAll() {
        return thongBao_tk_Impl.FindAll();
    }
}