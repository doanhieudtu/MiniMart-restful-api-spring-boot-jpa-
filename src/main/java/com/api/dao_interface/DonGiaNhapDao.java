package com.api.dao_interface;

import com.api.model.DonGiaNhap;

/**
 * Created by DELL on 09/17/2018.
 */
public interface DonGiaNhapDao extends GenericDao<DonGiaNhap, Integer> {
    DonGiaNhap FindByGetDate(String idProduct);
}