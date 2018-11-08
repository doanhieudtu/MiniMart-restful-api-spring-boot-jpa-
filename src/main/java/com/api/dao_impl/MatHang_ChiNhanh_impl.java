package com.api.dao_impl;

import com.api.dao_interface.MatHang_ChiNhanh_Dao;
import com.api.model.MatHang_ChiNhanh;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by DELL on 09/14/2018.
 */
@Repository
public class MatHang_ChiNhanh_impl extends  AbstractImpl<MatHang_ChiNhanh, Integer> implements MatHang_ChiNhanh_Dao{

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public List<MatHang_ChiNhanh> FindIdByOfBranch(int chiNhanh, int id) {
//        try {
            StringBuilder sql= new StringBuilder("SELECT P FROM ");
            sql.append("MatHang_ChiNhanh P");
            sql.append(" WHERE P.chiNhanh.machinhanh");
            sql.append(" = :ChiNhanh");
            sql.append(" AND ");
            sql.append(" P.ma_Mathang_chiNhanh");
            sql.append(" =:ID");
            Query query= entityManager.createQuery(sql.toString());
            query.setParameter("ID", id);
            return  (List<MatHang_ChiNhanh>) query.getResultList();
//        }
//        catch (Exception e){}
//        return null;
    }

    @Transactional
    @Override
    public List<MatHang_ChiNhanh> FindContentLike(int chiNhanh, String noiDung) {
          try {
              StringBuilder sql= new StringBuilder("SELECT P FROM ");
              sql.append("MatHang_ChiNhanh P");
              sql.append(" WHERE P.chiNhanh.machinhanh");
              sql.append(" = :ChiNhanh");
              sql.append(" AND ");
              sql.append(" P.matHang.tenhang");
              sql.append(" LIKE ");
              sql.append(":NoiDung");
              Query query= entityManager.createQuery(sql.toString());
              query.setParameter("ChiNhanh", chiNhanh);
              query.setParameter("NoiDung","%"+noiDung+"%");
              return (List<MatHang_ChiNhanh>) query.getResultList();
          }
          catch (Exception e){}
          return  null;
   }
}