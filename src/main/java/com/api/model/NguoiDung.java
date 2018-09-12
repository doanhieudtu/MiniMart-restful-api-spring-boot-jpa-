package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 08/23/2018.
 */
@Entity
@Table( name = "NguoiDung")
@XmlRootElement(name = "NguoiDung")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NguoiDung {
    /*mã người dùng*/
    @Id
    @Column(name = "MaND")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maND;

    /*họ tên người dùng*/
    @Column(name = "HoTen")
    private String hoTen;

    /*ngày sinh người dùng*/
    @Column(name = "NgaySinh")
    private Date ngaySinh;

    /*giới tính */
    @Column(name = "GioiTinh")
    private boolean gioiTinh;

    /*địa chỉ*/
    @Column(name = "DiaChi")
    private String diaChi;

    /* số điện thoại*/
    @Column(name = "SoDT")
    private String soDT;

    /*1 người dùng chỉ có 1 tài khoản đăng nhập*/
    @JsonBackReference
    @OneToOne(mappedBy = "nguoiDung", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private  TaiKhoan taiKhoan;

    /*nhiều người dùng thuộc 1 chi nhánh*/

    @ManyToOne
    @JoinColumn(name = "MaChiNhanh")
    @JsonBackReference
    private ChiNhanh chiNhanh;

    /*1 nhân viên(* người dùng) lập được nhiều phiếu nhập */
    @JsonBackReference
    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY)
    private List<PhieuNhap> lsPhieuNhap;

    /*1 nhân viên(* người dùng) lập được nhiều phiếu xuất*/
    @JsonBackReference
    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY)
    private List<PhieuXuat> lsPhieuXuat;

    /*1 nhân viên(* người dùng) lập được nhiều hóa đơn*/
    @JsonBackReference
    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY)
    private List<DonHang> lsDonHang;

    public NguoiDung() {
        List<PhieuNhap> lsPhieuNhap= new ArrayList<>();
        List<PhieuXuat> lsPhieuXuat= new ArrayList<>();
        List<DonHang> lsDonHang= new ArrayList<>();
        this.lsPhieuNhap = lsPhieuNhap;
        this.lsPhieuXuat = lsPhieuXuat;
        this.lsDonHang = lsDonHang;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public List<PhieuNhap> getLsPhieuNhap() {
        return lsPhieuNhap;
    }

    public void setLsPhieuNhap(List<PhieuNhap> lsPhieuNhap) {
        this.lsPhieuNhap = lsPhieuNhap;
    }

    public List<PhieuXuat> getLsPhieuXuat() {
        return lsPhieuXuat;
    }

    public void setLsPhieuXuat(List<PhieuXuat> lsPhieuXuat) {
        this.lsPhieuXuat = lsPhieuXuat;
    }

    public List<DonHang> getLsDonHang() {
        return lsDonHang;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public void setLsDonHang(List<DonHang> lsDonHang) {
        this.lsDonHang = lsDonHang;
    }
}