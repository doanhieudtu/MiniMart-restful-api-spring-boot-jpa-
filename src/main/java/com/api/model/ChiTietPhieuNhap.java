package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 08/30/2018.
 */
@Entity
@Table(name = "ChiTietPhieuNhap")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChiTietPhieuNhap {
    /*Mã chi tiết*/
    @Id
    @Column(name = "MaCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCT;

    /*hàng trong bản chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaHang")
    private MatHang matHang;

    /*Phiếu nhập trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaPhieu")
    private PhieuNhap phieuNhap;

    /* số lượng cụ thể được nhập của 1 mặt hàng*/
    @Column(name = "SoLuong")
    private int soLuong;

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}