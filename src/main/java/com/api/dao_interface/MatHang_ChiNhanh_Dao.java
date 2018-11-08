package com.api.dao_interface;

import com.api.model.MatHang_ChiNhanh;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DELL on 09/14/2018.
 */
public interface MatHang_ChiNhanh_Dao extends GenericDao<MatHang_ChiNhanh,Integer> {
    List<MatHang_ChiNhanh> FindContentLike(int chiNhanh, String noiDung);
    List<MatHang_ChiNhanh> FindIdByOfBranch(int chiNhanh, int id);
}