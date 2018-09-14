package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 08/25/2018.
 */
@Entity
@Table(name = "ChiTietDonHang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChiTietDonHang {
    /*mã chi tiết*/
    @Id
    @Column(name = "MaCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCT;

    /*số lượng hàng được mua trong hóa đơn*/
    @Column(name = "SoLuong")
    private int soLuong;

    /* hàng trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Ma_Hang_ChiNhanh")
    private MatHang_ChiNhanh matHang_chiNhanh;

    /*hóa đơn trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaDH")
    private DonHang donHang;

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public MatHang_ChiNhanh getMatHang() {
        return matHang_chiNhanh;
    }

    public void setMatHang(MatHang_ChiNhanh matHang) {
        this.matHang_chiNhanh = matHang;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public MatHang_ChiNhanh getMatHang_chiNhanh() {
        return matHang_chiNhanh;
    }

    public void setMatHang_chiNhanh(MatHang_ChiNhanh matHang_chiNhanh) {
        this.matHang_chiNhanh = matHang_chiNhanh;
    }

}