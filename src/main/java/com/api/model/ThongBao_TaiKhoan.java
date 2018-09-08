package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 08/30/2018.
 */
@Entity
@Table(name = "ThongBao_TaiKhoan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ThongBao_TaiKhoan {
    /*mã chi tiết*/
    @Id
    @Column(name = "MaCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCT;

    /*Thông báo trong abngr chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaTB")
    private ThongBao thongBao;

    /*tài khoản trong bản chi tiết*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaTK")
    private TaiKhoan taiKhoan;

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public ThongBao getThongBao() {
        return thongBao;
    }

    public void setThongBao(ThongBao thongBao) {
        this.thongBao = thongBao;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}