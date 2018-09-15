package com.api.model;

import javax.persistence.*;

/**
 * Created by DELL on 09/16/2018.
 */
@Entity
@Table(name = "NhomNhaCungCap")
public class NhomNhaCCap {
    @Id
    @Column(name = "MaNhom")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhom;

    @Column(name = "TenNhom")
    String tenNhom;

    @Column(name = "GhiChu")
    String ghiChu;

    public int getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(int maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}