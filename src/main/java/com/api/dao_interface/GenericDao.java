package com.api.dao_interface;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public interface GenericDao<T,ID extends Serializable>{
    boolean Add(T entity);
    boolean Delete(T entity);
    boolean Update(T entity);
    Object[] FinbyProperty(String property, Object value);
    List<T> FindAll();
}