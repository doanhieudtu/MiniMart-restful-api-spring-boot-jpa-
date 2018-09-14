package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 08/23/2018.
 */
@Entity
@Table(name="TaiKhoan")
@XmlRootElement(name="TaiKhoan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaiKhoan {
    /*mã tài khoản*/
    @Id
    @Column(name="MaTK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTK;

    @Column(name = "MatKhau")
    private String matKhau;

    /*1 tài khoản chỉ thuộc sỡ hữu người dùng*/
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaND")
    private NguoiDung nguoiDung;

    /*1 phân quyền có thể được nhiều tài khoản sử dụng*/
    @JsonBackReference
    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<TaiKhoan_Quyen> lsTaiKhoanQuyen;

    /*1 Tài khoản có nhiều thông báo*/
    @JsonBackReference
    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<ThongBao_TaiKhoan> lsThongBaoTaiKhoan;

    public TaiKhoan() {
        List<TaiKhoan_Quyen> lsTaiKhoanQuyen= new ArrayList<>();
        List<ThongBao_TaiKhoan> lsThongBaoTaiKhoan= new ArrayList<>();
        this.lsTaiKhoanQuyen = lsTaiKhoanQuyen;
        this.lsThongBaoTaiKhoan = lsThongBaoTaiKhoan;
    }

    public void setMatk(int matk) {
        this.maTK = matk;
    }

    public NguoiDung getNguoi_dung() {
        return nguoiDung;
    }

    public void setNguoi_dung(NguoiDung nguoi_dung) {
        this.nguoiDung = nguoi_dung;
    }

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public List<TaiKhoan_Quyen> getLsTaiKhoanQuyen() {
        return lsTaiKhoanQuyen;
    }

    public void setLsTaiKhoanQuyen(List<TaiKhoan_Quyen> lsTaiKhoanQuyen) {
        this.lsTaiKhoanQuyen = lsTaiKhoanQuyen;
    }

    public List<ThongBao_TaiKhoan> getLsThongBaoTaiKhoan() {
        return lsThongBaoTaiKhoan;
    }

    public void setLsThongBaoTaiKhoan(List<ThongBao_TaiKhoan> lsThongBaoTaiKhoan) {
        this.lsThongBaoTaiKhoan = lsThongBaoTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}