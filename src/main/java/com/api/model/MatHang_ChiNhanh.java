package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 09/14/2018.
 */
@Entity
@Table(name = "MatHang_ChiNhanh")
@XmlRootElement(name="MatHang_ChiNhanh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatHang_ChiNhanh {

    @Id
    @Column(name = "Ma_Hang_ChiNhanh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_Mathang_chiNhanh;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaChiNhanh")
    ChiNhanh chiNhanh;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaHang")
    MatHang matHang;

    /*số lượng tồn trong kho*/
    @Column(name = "SoLuongTon")
    private int soLuongTon;

    /*số lượng có tại cửa hàng*/
    @Column(name = "SoLuongDangBan")
    private int soLuongDangBan;

    /*ngày sản xuất*/
    @Column(name = "NgaySanXuat")
    private Date ngaysanxuat;

    /*hạn sử dụng*/
    @Column(name = "HanSuDung")
    private int hansudung;

    /*đã đồng bộ ảnh*/
    @Column(name ="DongBoAnh")
    private boolean  dongBoanh;
        /*1 mặt hàng của chi nhánh có thể xuất hiện trong nhiều phiếu nhập*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang_ChiNhanh", fetch = FetchType.LAZY)
    private List<ChiTietPhieuNhap> lsChiTietPhieuNhap;

    /*1 mặt hàng  của chi nhánh có thể xuất hiện trong nhiều phiếu xuất*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang_ChiNhanh", fetch = FetchType.LAZY)
    private List<ChiTietPhieuXuat> lsChiTietPhieuXuat;

    /* 1 mặt hàng của chi nhánh có thể nằm trong nhiều kho hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang_ChiNhanh", fetch = FetchType.LAZY)
    private List<KhoHang_Hang> lsCTKhoHang;

    /* 1 mặt hàng của chi nhánh có thể xuất hiện ở nhiều đơn hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "matHang_chiNhanh", fetch =FetchType.LAZY)
    List<ChiTietDonHang> hangTrongdonHang;

    public Date getNgaysanxuat() {
        return ngaysanxuat;
    }

    public boolean isDongBoanh() {
        return dongBoanh;
    }

    public void setDongBoanh(boolean dongBoanh) {
        this.dongBoanh = dongBoanh;
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

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getMa_Mathang_chiNhanh() {
        return ma_Mathang_chiNhanh;
    }

    public void setMa_Mathang_chiNhanh(int ma_Mathang_chiNhanh) {
        this.ma_Mathang_chiNhanh = ma_Mathang_chiNhanh;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public int getSoLuongDangBan() {
        return soLuongDangBan;
    }

    public void setSoLuongDangBan(int soLuongDangBan) {
        this.soLuongDangBan = soLuongDangBan;
    }

    public List<ChiTietPhieuNhap> getLsChiTietPhieuNhap() {
        return lsChiTietPhieuNhap;
    }

    public void setLsChiTietPhieuNhap(List<ChiTietPhieuNhap> lsChiTietPhieuNhap) {
        this.lsChiTietPhieuNhap = lsChiTietPhieuNhap;
    }

    public List<ChiTietPhieuXuat> getLsChiTietPhieuXuat() {
        return lsChiTietPhieuXuat;
    }

    public void setLsChiTietPhieuXuat(List<ChiTietPhieuXuat> lsChiTietPhieuXuat) {
        this.lsChiTietPhieuXuat = lsChiTietPhieuXuat;
    }

    public List<KhoHang_Hang> getLsCTKhoHang() {
        return lsCTKhoHang;
    }

    public void setLsCTKhoHang(List<KhoHang_Hang> lsCTKhoHang) {
        this.lsCTKhoHang = lsCTKhoHang;
    }

    public List<ChiTietDonHang> getHangTrongdonHang() {
        return hangTrongdonHang;
    }

    public void setHangTrongdonHang(List<ChiTietDonHang> hangTrongdonHang) {
        this.hangTrongdonHang = hangTrongdonHang;
    }
}