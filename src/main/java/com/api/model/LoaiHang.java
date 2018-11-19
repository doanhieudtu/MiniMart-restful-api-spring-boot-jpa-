package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 08/23/2018.
 */
@Entity
@Table(name="LoaiHang")
@XmlRootElement(name="LoaiHang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LoaiHang {
    @Id
    @Column(name="LoaiHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  maloai;

    public LoaiHang() {
        List<MatHang> ls_Mat_hang= new ArrayList<>();
        this.ls_Mat_hang = ls_Mat_hang;
    }

    @Column(name = "TenLoai")
    private String tenloai;

    /*1 mặt hàng có nhiều sản phẩm*/
    @JsonBackReference
    @OneToMany(mappedBy = "loaiHang", fetch = FetchType.LAZY)
    private List<MatHang> ls_Mat_hang;

    /*1 loại hàng chỉ được chứa trong 1 kho hàng*/
    @JsonBackReference
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "MaKhoHang")
    private KhoHang khoHang;

    /*Loại l hàng đc cung cấp nhiều nhà cung cấp*/
    @JsonBackReference
    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    List<NhaCC_LoaiHang> lsNhaCC_loaiHang;

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public List<MatHang> getLs_Mat_hang() {
        return ls_Mat_hang;
    }

    public void setLs_Mat_hang(List<MatHang> ls_Mat_hang) {
        this.ls_Mat_hang = ls_Mat_hang;
    }
}