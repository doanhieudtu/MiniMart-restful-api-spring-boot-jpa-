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

    /*ngày sản xuất*/
    @Column(name = "NgaySanXuat")
    private Date ngaysanxuat;

    /*hạn sử dụng*/
    @Column(name = "HanSuDung")
    private int hansudung;

    /*số lượng tồn trong kho*/
    @Column(name = "SoLuongTon")
    private int soLuongTon;

    /*số lượng có tại cửa hàng*/
    @Column(name = "SoLuongDangBan")
    private int soLuongDangBan;

    /* giá bán của mặt hàng*/
    @Column(name = "GiaBanRa")
    private long giaBanRa;

    /* giá nhập vào của nhà cung cấp*/
    @Column(name = "GiaNhapVao")
    private double giaNhapVao;

    /* hình ảnh sản mặt hàng*/
    @Column(name = "HinhAnh")
    private String hinhAnh;

    /*1 mặt hàng có thể xuất hiện trong nhiều phiếu nhập*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang", fetch = FetchType.LAZY)
    private List<ChiTietPhieuNhap> lsChiTietPhieuNhap;

    /*1 mặt hàng có thể xuất hiện trong nhiều phiếu xuất*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang", fetch = FetchType.LAZY)
    private List<ChiTietPhieuXuat> lsChiTietPhieuXuat;

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

    /* 1 mặt hàng có thể xuất hiện ở nhiều đơn hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "donHang", fetch =FetchType.LAZY)
    List<ChiTietDonHang> hangDonHang;

    /* 1 mặt hàng có thể nằm trong nhiều kho hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang", fetch = FetchType.LAZY)
    private List<KhoHang_Hang> lsCTKhoHang;
//
//    public MatHang() {
//        List<ChiTietPhieuNhap> lsChiTietPhieuNhap= new ArrayList<>();
//        List<ChiTietPhieuXuat> lsChiTietPhieuXuat= new ArrayList<>();
//        List<NhaCC_MatHang> lsNhaCungCap_MatHang= new ArrayList<>();
//        List<ChiTietDonHang> hangDonHang= new ArrayList<>();
//        List<KhoHang_Hang> lsCTKhoHang= new ArrayList<>();
//        this.lsChiTietPhieuNhap = lsChiTietPhieuNhap;
//        this.lsChiTietPhieuXuat = lsChiTietPhieuXuat;
//        this.lsNhaCungCap_MatHang = lsNhaCungCap_MatHang;
//        this.hangDonHang = hangDonHang;
//        this.lsCTKhoHang = lsCTKhoHang;
//    }

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

    public Date getNgaysanxuat() {
        return ngaysanxuat;
    }

    public void setNgaysanxuat(Date ngaysanxuat) {
        this.ngaysanxuat = ngaysanxuat;
    }

    public int getHansudung() {
        return hansudung;
    }

    public void setHansudung(int hansudung) {
        this.hansudung = hansudung;
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

    public List<ChiTietDonHang> getHangDonHang() {
        return hangDonHang;
    }

    public void setHangDonHang(List<ChiTietDonHang> hangDonHang) {
        this.hangDonHang = hangDonHang;
    }



    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

}