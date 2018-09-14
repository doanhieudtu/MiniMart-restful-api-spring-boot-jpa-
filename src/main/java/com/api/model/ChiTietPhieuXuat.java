package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 08/30/2018.
 */
@Entity
@Table(name = "ChiTietPhieuXuat")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChiTietPhieuXuat {
    @Id
    @Column(name = "MaCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCT;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Ma_Hang_ChiNhanh")
    private MatHang_ChiNhanh matHang_ChiNhanh;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaPhieu")
    private PhieuXuat phieuXuat;

    @Column(name = "SoLuong")
    private int soLuong;

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public MatHang_ChiNhanh getMatHang() {
        return matHang_ChiNhanh;
    }

    public void setMatHang(MatHang_ChiNhanh matHang) {
        this.matHang_ChiNhanh = matHang;
    }

    public PhieuXuat getPhieuXuat() {
        return phieuXuat;
    }

    public void setPhieuXuat(PhieuXuat phieuXuat) {
        this.phieuXuat = phieuXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public MatHang_ChiNhanh getMatHang_ChiNhanh() {
        return matHang_ChiNhanh;
    }

    public void setMatHang_ChiNhanh(MatHang_ChiNhanh matHang_ChiNhanh) {
        this.matHang_ChiNhanh = matHang_ChiNhanh;
    }
}