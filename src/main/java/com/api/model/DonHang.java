package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 08/25/2018.
 */
@Entity
@Table(name = "DonHang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DonHang  {

    @Id
    @Column(name = "MaDH")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int madonhang;

    @Column(name = "VAT")
    private double vat;

    @Column(name = "NgayLap")
    private Date ngaylap;

    @Column(name = "ChietKhau")
    private float chietKhau;

    @ManyToOne
    @JoinColumn(name = "MaChiNhanh")
    private ChiNhanh chiNhanh;
    /*1 đơn hàng có nhiều mặt hàng*/
    @JsonBackReference
    @OneToMany(mappedBy = "donHang", fetch = FetchType.LAZY)
    List<ChiTietDonHang> lsCTDonHang;

    public DonHang() {
        List<ChiTietDonHang> lsCTDonHang= new ArrayList<>();
        this.lsCTDonHang = lsCTDonHang;
        this.nguoiDung = new NguoiDung();
    }

    public float getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(float chietKhau) {
        this.chietKhau = chietKhau;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MaND")
    private NguoiDung nguoiDung;

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public List<ChiTietDonHang> getLsCTDonHang() {
        return lsCTDonHang;
    }

    public void setLsCTDonHang(List<ChiTietDonHang> lsDonHang) {
        this.lsCTDonHang = lsDonHang;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }
}