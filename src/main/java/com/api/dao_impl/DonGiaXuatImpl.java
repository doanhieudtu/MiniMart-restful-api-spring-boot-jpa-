package com.api.dao_impl;

import com.api.dao_interface.DonGiaXuatDao;
import com.api.model.DonGiaNhap;
import com.api.model.DonGiaXuat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by DELL on 09/17/2018.
 */
@Repository
public class DonGiaXuatImpl extends AbstractImpl<DonGiaXuat,Integer> implements DonGiaXuatDao{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public DonGiaXuat FindByGetDate(String idProduct) {
        if(!idProduct.isEmpty()){
            StringBuilder sql= new StringBuilder("SELECT P FROM DonGiaXuat P");
            sql.append(" WHERE ");
            sql.append("P.matHang.mahang");
            sql.append("= :MaHang ");
            sql.append("AND ");
            sql.append("CURRENT_DATE() BETWEEN P.ngayBatDau AND P.ngayKetThuc");
            Query query =entityManager.createQuery(sql.toString());
            query.setParameter("MaHang", idProduct);
            DonGiaXuat result = (DonGiaXuat) query.getSingleResult();
            return result;
        }
        return null;
    }
}