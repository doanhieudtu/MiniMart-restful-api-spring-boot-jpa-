package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 09/05/2018.
 */
@Entity
@Table(name = "NhaCC_MatHang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class NhaCC_MatHang {

    /* mã chi tiết*/
    @Id
    @Column(name = "MaCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCT;

    /*Mặt hàng trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaHang")
    private MatHang matHang;

    /*Nhà cung cấp trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaNhaCCap")
    private NhaCungCap nhaCungCap;

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

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}