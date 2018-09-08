package com.api.model;

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
@Table(name = "PhieuNhap")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PhieuNhap {

    /*Mã phiếu nhập*/
    @Id
    @Column(name = "MaPhieu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maPhieu;

    /*ngày tạo phiếu*/
    @Column(name = "NgayTao")
    private Date ngayTao;

    /*Nhiều phiếu nhập có cùng mã kho*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaKho")
    private KhoHang khoHang;

    /*Nhiều phiếu nhập cđược lập bởi 1 người dùng*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaND")
    private NguoiDung nguoiDung;

    public PhieuNhap() {
        List<ChiTietPhieuNhap> lsPhieuNhap= new ArrayList<>();
        this.lsPhieuNhap = lsPhieuNhap;
    }

    /*1 phiếu nhập có thể có nhiều mặt hàng*/
    @OneToMany(mappedBy = "phieuNhap", fetch = FetchType.LAZY)



    private List<ChiTietPhieuNhap> lsPhieuNhap;

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public KhoHang getKhoHang() {
        return khoHang;
    }

    public void setKhoHang(KhoHang khoHang) {
        this.khoHang = khoHang;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public List<ChiTietPhieuNhap> getLsPhieuNhap() {
        return lsPhieuNhap;
    }

    public void setLsPhieuNhap(List<ChiTietPhieuNhap> lsPhieuNhap) {
        this.lsPhieuNhap = lsPhieuNhap;
    }
}