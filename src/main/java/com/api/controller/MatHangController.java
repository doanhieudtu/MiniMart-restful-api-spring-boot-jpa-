package com.api.controller;

import com.api.model.DonGiaNhap;
import com.api.model.DonGiaXuat;
import com.api.model.LoaiHang;
import com.api.service.DonGiaNhapService;
import com.api.service.DonGiaXuatService;
import com.api.service.LoaiHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 12/04/2018.
 */
@RestController
@RequestMapping("/mat-hang/")
public class MatHangController {

    @Autowired
    DonGiaNhapService donGiaNhapService;

    @Autowired
    DonGiaXuatService donGiaXuatService;

    @Autowired
    LoaiHangService loaiHangService;

    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RequestMapping("don-gia-nhap")
    @GET
    public DonGiaNhap getDonGiaNhapByDate(@RequestParam String idProduct){
        if(!idProduct.isEmpty())
        {
            try {
                return donGiaNhapService.FindByGetDate(idProduct);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RequestMapping("don-gia-xuat")
    @GET
    public DonGiaXuat getDonGiaXuatByDate(@RequestParam String idProduct){
        if(!idProduct.isEmpty())
        {
            try {
                return donGiaXuatService.FindByGetDate(idProduct);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RequestMapping("danh-muc")
    @GET
    public List<LoaiHang> getCategory(){
            List<LoaiHang> ls= new ArrayList<>();
            return loaiHangService.FindAll();
    }
}