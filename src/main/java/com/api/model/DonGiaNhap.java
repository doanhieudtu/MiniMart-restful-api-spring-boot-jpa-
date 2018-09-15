package com.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DELL on 09/16/2018.
 */
@Entity
@Table(name = "DonGiaNhap")
public class DonGiaNhap {
    @Id
    @Column(name = "MaDonGia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDongia;

    @Column(name = "ngayBatDau")
    private Date ngayBatDau;

    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "GiaNhap")
    private double giaNhap;

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

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }
}