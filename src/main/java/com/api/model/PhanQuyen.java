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
@Table(name="PhanQuyen")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PhanQuyen {
    /*mã quyền*/
    @Id
    @Column(name="MaQuyen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maquyen;

    /* vai trò người dùng*/
    @Column(name="VaiTro")
    private String vaitro;

    /*1 tài khoản có thể có nhiều quyền */
    @JsonBackReference
    @OneToMany(mappedBy = "phanQuyen", fetch = FetchType.LAZY)
    List<TaiKhoan_Quyen> lsTaiKhoanQuyen;

    public PhanQuyen() {
        List<TaiKhoan_Quyen> lsTaiKhoanQuyen= new ArrayList<>();
        this.lsTaiKhoanQuyen = lsTaiKhoanQuyen;
    }

    public int getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(int maquyen) {
        this.maquyen = maquyen;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }


}