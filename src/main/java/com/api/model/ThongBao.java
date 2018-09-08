package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by DELL on 08/24/2018.
 */
@Entity
@Table(name = "ThongBao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ThongBao {
    /*mã thông báo*/
    @Id
    @Column(name = "MaTB")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTB;

    /*chủ đề thông báo*/
    @Column(name = "ChuDe")
    private String chuDe;

    /*nội dung thông báo*/
    @Column(name="NoiDung")
    private String noiDung;
    /* ngày soạn*/
    @Column(name = "NgaySoan")
    private Date ngaySoan;

    /*trạng thái đã đọc thư */
    @Column(name = "DaDoc")
    private boolean daDoc;

    /* 1 thông báo được gửi cho nhiều tài khoản*/
    @JsonBackReference
    @OneToMany(mappedBy = "thongBao")
    List<ThongBao_TaiKhoan> lsThongBaoTaiKhoan;

    public ThongBao() {
        List<ThongBao_TaiKhoan> lsThongBaoTaiKhoan= new ArrayList<>();
        this.lsThongBaoTaiKhoan = lsThongBaoTaiKhoan;
    }

    public int getMaTB() {
        return maTB;
    }

    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }

    public String getChuDe() {
        return chuDe;
    }

    public void setChuDe(String chuDe) {
        this.chuDe = chuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgaySoan() {
        return ngaySoan;
    }

    public void setNgaySoan(Date ngaySoan) {
        this.ngaySoan = ngaySoan;
    }

    public boolean getDaDoc() {
        return daDoc;
    }

    public void setDaDoc(boolean daDoc) {
        this.daDoc = daDoc;
    }

    public List<ThongBao_TaiKhoan> getLsThongBaoTaiKhoan() {
        return lsThongBaoTaiKhoan;
    }

    public void setLsThongBaoTaiKhoan(List<ThongBao_TaiKhoan> lsThongBaoTaiKhoan) {
        this.lsThongBaoTaiKhoan = lsThongBaoTaiKhoan;
    }
}