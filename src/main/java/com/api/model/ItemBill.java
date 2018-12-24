package com.api.model;

/**
 * Created by DELL on 12/20/2018.
 */
public class ItemBill {
    private String maSP;
    private int soLuong;

    public String getMaSP() {
        return maSP;
    }

    public ItemBill(String maSP, int soLuong) {
        this.maSP = maSP;
        this.soLuong = soLuong;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}