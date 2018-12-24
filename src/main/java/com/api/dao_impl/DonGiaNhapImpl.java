package com.api.dao_impl;

import com.api.dao_interface.DonGiaNhapDao;
import com.api.model.DonGiaNhap;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
@Repository
public class DonGiaNhapImpl extends AbstractImpl<DonGiaNhap, Integer> implements DonGiaNhapDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public DonGiaNhap FindByGetDate(String idProduct) {
        if(!idProduct.isEmpty()){
            StringBuilder sql= new StringBuilder("SELECT P FROM DonGiaNhap P");
            sql.append(" WHERE ");
            sql.append("P.matHang.mahang");
            sql.append("= :MaHang ");
            sql.append("AND ");
            sql.append("CURRENT_DATE() BETWEEN P.ngayBatDau AND P.ngayKetThuc");
            Query query =entityManager.createQuery(sql.toString());
            query.setParameter("MaHang", idProduct);
            DonGiaNhap result = (DonGiaNhap) query.getSingleResult();
            return result;
        }
        return null;
    }
}