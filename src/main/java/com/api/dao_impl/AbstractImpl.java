package com.api.dao_impl;

import com.api.dao_interface.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 09/06/2018.
 */
public class AbstractImpl<T,ID extends Serializable> implements GenericDao<T,ID> {

    @Autowired
    EntityManager entityManager;
    private Class<T> persistenceClass;

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public void setPersistenceClass(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }
    @SuppressWarnings("unchecked")
    public AbstractImpl() {
        Type genericSuperClass = getClass().getGenericSuperclass();

        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
            if ((genericSuperClass instanceof ParameterizedType)) {
                parametrizedType = (ParameterizedType) genericSuperClass;
            } else {
                genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
            }
        }

        this.persistenceClass = (Class<T>) parametrizedType.getActualTypeArguments()[0];
    }
    private String getNamepersistence() {
        return this.persistenceClass.getSimpleName();
    }

    @Transactional
    @Override
    public boolean Add(T entity) {
        int status=0;
        try {
            entityManager.persist(entity);
            status=1;
        }
        catch (Exception e){
            throw e;
        }
        if(status==1) return true;
        return false;
    }

    @Transactional
    @Override
    public boolean Delete(T entity) {
        int status=0;
        try {
            entityManager.remove(entity);
            status=1;
        }catch (Exception e){throw  e;}
        return false;
    }

    @Transactional
    @Override
    public boolean Update(T entity ) {
        int status=0;
        try {
           entityManager.merge(entity);
        }catch (Exception e){throw  e;}
        return false;
    }

    @Transactional
    @Override
    public Object[] FinbyProperty(String property, Object value) {
        List<T> lIst= new ArrayList<T>();
        StringBuilder hQl= new StringBuilder("SELECT P FROM ");
        try {
            hQl.append(getNamepersistence()+" P");
            hQl.append(" WHERE ");
            if(property!=null && value!=null)
            {
                hQl.append("P."+property);
                hQl.append(" = :Value");
                Query query= entityManager.createQuery(hQl.toString());
                query.setParameter("Value",value);
                lIst= query.getResultList();
            }
        } catch (Exception e) {
            System.out.print(hQl);
            System.out.print(e);
            // TODO: handle exception
        }
        return new Object[]{lIst,lIst.size()};
    }

    @Transactional
    @Override
    public List<T> FindAll() {
        return entityManager.createQuery("SELECT P FROM "+getNamepersistence()+" P").getResultList();
    }
}