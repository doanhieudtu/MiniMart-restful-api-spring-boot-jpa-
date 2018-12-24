package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by DELL on 09/16/2018.
 */
@Entity
@Table(name = "DonGiaNhap")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DonGiaNhap {
    @Id
    @Column(name = "MaDonGia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDongia;

    @Column(name = "ngayBatDau")
    private Date ngayBatDau;

    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "DonGia")
    private double donGia;

    @ManyToOne
    @JoinColumn(name = "MaHang")
    private MatHang matHang;

    public int getMaDongia() {
        return maDongia;
    }

    public void setMaDongia(int maDongia) {
        this.maDongia = maDongia;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double giaNhap) {
        this.donGia = giaNhap;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }
}