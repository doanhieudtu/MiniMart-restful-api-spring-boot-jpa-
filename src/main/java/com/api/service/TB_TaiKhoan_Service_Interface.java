package com.api.service;

import com.api.model.ThongBao_TaiKhoan;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface TB_TaiKhoan_Service_Interface {
    boolean Add(ThongBao_TaiKhoan entity);
    boolean Delete(ThongBao_TaiKhoan entity);
    boolean Update(ThongBao_TaiKhoan entity);
    Object[] FinbyProperty(String property, Object value);
    List<ThongBao_TaiKhoan> FindAll();
}