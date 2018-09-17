package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 08/23/2018.
 */
@Entity
@Table(name = "NhaCungCap")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NhaCungCap {
    /* mã nhà cung cấp*/
    @Id
    @Column(name = "MaNhaCCap")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manhaccap;

    /*tên nhà cung cấp*/
    @Column(name="TenNhaCCap")
    private String tencongty;

    /* địa chỉ*/
    @Column(name="DiaChi")
    private String diachi;

    /* số điện thoại*/
    @Column(name = "SoDT")
    private String sodt;

    /*email*/
    @Column(name = "Email")
    private String email;

    @ManyToOne
    @JoinColumn(name="MaNhom")
    private NhomNhaCCap nhomNhaCCap;


    /*1 nhà cung cấp có thể cung cấp nhiều loại hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    List<NhaCC_LoaiHang> lsNhaCC_loaiHang;

    /*1 nhà cung cấp có thể cung cấp nhiều mặt hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    List<NhaCC_MatHang> ls_Mat_hang_NhaCC;

    public int getManhaccap() {
        return manhaccap;
    }

    public void setManhaccap(int manhaccap) {
        this.manhaccap = manhaccap;
    }

    public String getTencongty() {
        return tencongty;
    }

    public void setTencongty(String tencongty) {
        this.tencongty = tencongty;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NhaCungCap() {
        List<NhaCC_LoaiHang> lsNhaCC_loaiHang= new ArrayList<>();
        List<NhaCC_MatHang> ls_Mat_hang_NhaCC= new ArrayList<>();
        this.lsNhaCC_loaiHang = lsNhaCC_loaiHang;
        this.ls_Mat_hang_NhaCC = ls_Mat_hang_NhaCC;
        this.lsNhaCC_loaiHang = lsNhaCC_loaiHang;
    }

    public NhomNhaCCap getNhomNhaCCap() {
        return nhomNhaCCap;
    }

    public void setNhomNhaCCap(NhomNhaCCap nhomNhaCCap) {
        this.nhomNhaCCap = nhomNhaCCap;
    }

    public List<NhaCC_LoaiHang> getLsNhaCC_loaiHang() {
        return lsNhaCC_loaiHang;
    }

    public void setLsNhaCC_loaiHang(List<NhaCC_LoaiHang> lsNhaCC_loaiHang) {
        this.lsNhaCC_loaiHang = lsNhaCC_loaiHang;
    }

    public List<NhaCC_MatHang> getLs_Mat_hang_NhaCC() {
        return ls_Mat_hang_NhaCC;
    }

    public void setLs_Mat_hang_NhaCC(List<NhaCC_MatHang> ls_Mat_hang_NhaCC) {
        this.ls_Mat_hang_NhaCC = ls_Mat_hang_NhaCC;
    }
}