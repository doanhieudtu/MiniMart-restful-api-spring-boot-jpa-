package com.api.service;

import com.api.model.PhanQuyen;

import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface PhanQuyen_Service_Interface {
    boolean Add(PhanQuyen entity);
    boolean Delete(PhanQuyen entity);
    boolean Update(PhanQuyen entity);
    Object[] FinbyProperty(String property, Object value);
    List<PhanQuyen> FindAll();
}