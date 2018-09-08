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
    @JoinColumn(name = "MaHang")
    private MatHang matHang;

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

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public KhoHang getKhoHang() {
        return khoHang;
    }

    public void setKhoHang(KhoHang khoHang) {
        this.khoHang = khoHang;
    }
}