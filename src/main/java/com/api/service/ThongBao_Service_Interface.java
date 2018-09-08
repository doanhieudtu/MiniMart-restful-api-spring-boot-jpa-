package com.api.service;

import com.api.model.ThongBao;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface ThongBao_Service_Interface {
    boolean Add(ThongBao entity);
    boolean Delete(ThongBao entity);
    boolean Update(ThongBao entity);
    Object[] FinbyProperty(String property, Object value);
    List<ThongBao> FindAll();
}