package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 08/30/2018.
 */
@Entity
@Table(name = "TaiKhoan_Quyen")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaiKhoan_Quyen {
    /*mã chi tiết */
    @Id
    @Column(name = "MaCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCT;
    /* tài khoản trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaTK")
    private TaiKhoan taiKhoan;

    /* phân quyền trong bảng chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaQuyen")
    private  PhanQuyen phanQuyen;


    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public PhanQuyen getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(PhanQuyen phanQuyen) {
        this.phanQuyen = phanQuyen;
    }
}