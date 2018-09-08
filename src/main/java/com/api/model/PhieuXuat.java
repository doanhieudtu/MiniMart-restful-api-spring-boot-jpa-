package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 08/23/2018.
 */
@Entity
@Table(name = "PhieuXuat")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PhieuXuat {
    /*mã phiếu xuất*/
    @Id
    @Column(name = "MaPhieu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maPhieuXuat;

    /*Nhiều phiếu xuất được xuất từ 1 kho*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaKho")
    private KhoHang khoHang;

    /*Nhiều phiếu xuất được lập bởi 1 người dùng*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaND")
    private NguoiDung nguoiDung;

    /*1 phiếu xuất có nhiều mặt hàng*/
    @OneToMany(mappedBy = "phieuXuat")
    private List<ChiTietPhieuXuat> lsPhieuXuat;

    public PhieuXuat() {
        List<ChiTietPhieuXuat> lsPhieuXuat= new ArrayList<>();
        this.lsPhieuXuat = lsPhieuXuat;
    }

    public int getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
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

    public List<ChiTietPhieuXuat> getLsPhieuXuat() {
        return lsPhieuXuat;
    }

    public void setLsPhieuXuat(List<ChiTietPhieuXuat> lsPhieuXuat) {
        this.lsPhieuXuat = lsPhieuXuat;
    }
}