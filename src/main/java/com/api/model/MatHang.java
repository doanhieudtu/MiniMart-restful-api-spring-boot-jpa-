package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 08/23/2018.
 */
@Entity
@Table(name = "MatHang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatHang {

    /*Mã mặt hàng*/
    @Id
    @Column(name = "MaHang")
    private String mahang;

    /* tên mặt hàng*/
    @Column(name = "TenHang")
    private  String tenhang;

    /* giá bán của mặt hàng*/
    @Column(name = "GiaBanRa")
    private double giaBanRa;

    /* giá nhập vào của nhà cung cấp*/
    @Column(name = "GiaNhapVao")
    private double giaNhapVao;

    /* hình ảnh sản mặt hàng*/
    @Column(name = "HinhAnh")
    private String hinhAnh;

    /* 1 mặt hàng xuất hiện ở nhiều chi nhánh khác nhau về số lượng*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang", fetch = FetchType.LAZY)
    private List<MatHang_ChiNhanh> lsMatHang_ChiNhanh;

    /* 1 mặt hàng được nhập từ nhiều nhà cung cấp*/
    @OneToMany(mappedBy = "matHang", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<NhaCC_MatHang> lsNhaCungCap_MatHang;

    /*đơn vị tính sản phẩm*/
    @Column(name = "DonViTinh")
    private String donvitinh;

    /* nhiều mặt hàng thuộc 1 loại hàng*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaLoaiHang")
    private LoaiHang loaiHang;

    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public double getGiaBanRa() {
        return giaBanRa;
    }

    public void setGiaBanRa(long giaBanRa) {
        this.giaBanRa = giaBanRa;
    }

    public double getGiaNhapVao() {
        return giaNhapVao;
    }

    public void setGiaNhapVao(double giaNhapVao) {
        this.giaNhapVao = giaNhapVao;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public List<MatHang_ChiNhanh> getLsMatHang_ChiNhanh() {
        return lsMatHang_ChiNhanh;
    }

    public void setLsMatHang_ChiNhanh(List<MatHang_ChiNhanh> lsMatHang_ChiNhanh) {
        this.lsMatHang_ChiNhanh = lsMatHang_ChiNhanh;
    }

    public List<NhaCC_MatHang> getLsNhaCungCap_MatHang() {
        return lsNhaCungCap_MatHang;
    }

    public void setLsNhaCungCap_MatHang(List<NhaCC_MatHang> lsNhaCungCap_MatHang) {
        this.lsNhaCungCap_MatHang = lsNhaCungCap_MatHang;
    }

    public LoaiHang getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHang loaiHang) {
        this.loaiHang = loaiHang;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public LoaiHang getLoaihang() {
        return loaiHang;
    }

    public void setLoaihang(LoaiHang loaihang) {
        this.loaiHang = loaihang;
    }

}