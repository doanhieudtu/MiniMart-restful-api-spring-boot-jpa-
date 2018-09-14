package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by DELL on 09/05/2018.
 */
@Entity
@Table(name ="KhoHang_Hang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class KhoHang_Hang
{
    @Id
    @Column(name = "MaCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int maCT;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Ma_Hang_ChiNhanh")
    private MatHang_ChiNhanh matHang_ChiNhanh;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaKhoHang")
    private KhoHang khoHang;

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public MatHang_ChiNhanh getMatHang() {
        return matHang_ChiNhanh;
    }

    public void setMatHang(MatHang_ChiNhanh matHang) {
        this.matHang_ChiNhanh = matHang;
    }

    public KhoHang getKhoHang() {
        return khoHang;
    }

    public void setKhoHang(KhoHang khoHang) {
        this.khoHang = khoHang;
    }
}