package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 08/24/2018.
 */
@Entity
@Table(name = "KhoHang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class KhoHang {
    @Id
    @Column(name = "MaKhoHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhoHang;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "MaChiNhanh")
    private ChiNhanh chiNhanh;

    @Column(name="TenKhoHang")
    private String tenKhoHang;

    @Column(name = "DiaChi")
    private String diaChi;

    /*1 kho hàng  chứa 1 loại hàng duy nhất*/
    @JsonManagedReference
    @OneToOne( mappedBy = "khoHang",cascade = CascadeType.ALL, optional = false)
    private LoaiHang loaiHang;

    /* 1 kho hàng chứa cùng 1 mặt hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "khoHang", fetch = FetchType.LAZY)
    private List<KhoHang_Hang> lsKhoHang_Hang;

    /*1 kho có nhiều phiếu xuất*/
    @JsonBackReference
    @OneToMany(mappedBy = "khoHang")
    private List<PhieuXuat> lsPhieuXuat;

    /*1 kho có nhiều phiếu nhập */
    @JsonBackReference
    @OneToMany(mappedBy = "khoHang")
    private List<PhieuNhap> lsPhieuNhap;

    public KhoHang() {
        List<KhoHang_Hang> lsKhoHang_Hang= new ArrayList<>();
        List<PhieuXuat> lsPhieuXuat= new ArrayList<>();
        List<PhieuNhap> lsPhieuNhap= new ArrayList<>();
        this.chiNhanh = chiNhanh;
        this.loaiHang = loaiHang;
        this.lsKhoHang_Hang = lsKhoHang_Hang;
        this.lsPhieuXuat = lsPhieuXuat;
        this.lsPhieuNhap = lsPhieuNhap;
    }

    public int getMaKhoHang() {
        return maKhoHang;
    }

    public void setMaKhoHang(int maKhoHang) {
        this.maKhoHang = maKhoHang;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public String getTenKhoHang() {
        return tenKhoHang;
    }

    public void setTenKhoHang(String tenKhoHang) {
        this.tenKhoHang = tenKhoHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LoaiHang getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHang loaiHang) {
        this.loaiHang = loaiHang;
    }

    public List<KhoHang_Hang> getLsKhoHang_Hang() {
        return lsKhoHang_Hang;
    }

    public void setLsKhoHang_Hang(List<KhoHang_Hang> lsKhoHang_Hang) {
        this.lsKhoHang_Hang = lsKhoHang_Hang;
    }

    public List<PhieuXuat> getLsPhieuXuat() {
        return lsPhieuXuat;
    }

    public void setLsPhieuXuat(List<PhieuXuat> lsPhieuXuat) {
        this.lsPhieuXuat = lsPhieuXuat;
    }

    public List<PhieuNhap> getLsPhieuNhap() {
        return lsPhieuNhap;
    }

    public void setLsPhieuNhap(List<PhieuNhap> lsPhieuNhap) {
        this.lsPhieuNhap = lsPhieuNhap;
    }
}