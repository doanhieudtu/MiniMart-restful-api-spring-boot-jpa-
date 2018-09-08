package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 08/29/2018.
 */
@Entity
@Table(name = "NhaCC_LoaiHang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NhaCC_LoaiHang {
    /*mã chi tiết*/
    @Id
    @Column(name = "MaChiTiet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maChiTiet;

    /*Nhà cung cấp trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaNhaCCap")
    private NhaCungCap nhaCungCap;

    /* Kho hàng trong bảng chi tiết*/
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "MaKhoHang")
    private KhoHang khoHang;

    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public KhoHang getKhoHang() {
        return khoHang;
    }

    public void setKhoHang(KhoHang khoHang) {
        this.khoHang = khoHang;
    }
}