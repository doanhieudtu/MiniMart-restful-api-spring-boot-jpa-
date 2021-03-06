package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 08/23/2018.
 */
@Entity
@Table(name="ChiNhanh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChiNhanh implements Serializable {
    /*Mã chi nhánh*/
    @Id
    @Column(name = "MaChiNhanh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int machinhanh;

    /*địa chỉ chi nhánh*/
    @Column(name = "DiaChi")
    private String diachi;

    /*số điện thoại chi nhánh*/
    @Column(name="SoDT")
    private String sodt;

    /* 1 chi nhánh có nhiều hóa đơn*/
    @JsonBackReference
    @OneToMany(mappedBy = "chiNhanh", fetch = FetchType.LAZY)
    List<DonHang> lsHoaDon;

    /*1 chi nhánh có nhiều kho hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "chiNhanh", fetch = FetchType.LAZY)
    List<KhoHang> lsKhoHang;

    /* 1 chi nhánh có nhiều người  dùng*/
    @JsonBackReference
    @OneToMany(mappedBy = "chiNhanh", fetch = FetchType.LAZY)
    List<NguoiDung> lsNguoiDung;

    /*1 chi nhánh có nhiều mặt hàng khác nhau về số lượng của các chi nhánh khác */
    @JsonBackReference
    @OneToMany(mappedBy = "chiNhanh", fetch = FetchType.LAZY)
    private List<MatHang_ChiNhanh> lsMatHang_ChiNhanh;


    public ChiNhanh() {
        List<DonHang> lsHoaDon= new ArrayList<>();
        List<KhoHang> lsKhoHang= new ArrayList<>();
        List<NguoiDung> lsNguoiDung= new ArrayList<>();
        this.lsHoaDon = lsHoaDon;
        this.lsKhoHang = lsKhoHang;
        this.lsNguoiDung = lsNguoiDung;
    }

    public int getMachinhanh() {
        return machinhanh;
    }

    public void setMachinhanh(int machinhanh) {
        this.machinhanh = machinhanh;
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

    public List<DonHang> getLsHoaDon() {
        return lsHoaDon;
    }

    public void setLsHoaDon(List<DonHang> lsHoaDon) {
        this.lsHoaDon = lsHoaDon;
    }

    public List<KhoHang> getLsKhoHang() {
        return lsKhoHang;
    }

    public void setLsKhoHang(List<KhoHang> lsKhoHang) {
        this.lsKhoHang = lsKhoHang;
    }

    public List<NguoiDung> getLsNguoiDung() {
        return lsNguoiDung;
    }

    public void setLsNguoiDung(List<NguoiDung> lsNguoiDung) {
        this.lsNguoiDung = lsNguoiDung;
    }

    public List<MatHang_ChiNhanh> getLsMatHang_ChiNhanh() {
        return lsMatHang_ChiNhanh;
    }

    public void setLsMatHang_ChiNhanh(List<MatHang_ChiNhanh> lsMatHang_ChiNhanh) {
        this.lsMatHang_ChiNhanh = lsMatHang_ChiNhanh;
    }
}