package com.api.controller;

import com.api.model.*;
import com.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 09/07/2018.
 */
@RestController
@RequestMapping("/demo/")
public class DemoController {
    @Autowired
    NguoiDungService nguoiDungService;

    @Autowired
    ChiNhanhService chiNhanhService;

    @Autowired
    MatHangService matHangService;

    @Autowired
    LoaiHangService loaiHangService;

    @Autowired
    PhanQuyenService phanQuyenService;

    @Autowired
    TaiKhoanService taiKhoanService;


    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @GetMapping("tai-khoan-chi-nhanh")
    public String ChiNhanhIDofAcc(@RequestParam String id) throws Throwable{
        List<NguoiDung> lsUser= new ArrayList<>();
        lsUser=(List<NguoiDung>)nguoiDungService.FinbyProperty("maND", Integer.parseInt(id))[0];
        return lsUser.get(0).getChiNhanh().getDiachi();
    }
    @ResponseBody
    @Produces({ MediaType.APPLICATION_JSON})
    @GetMapping("ls-nguoi-dung")
    public List<TaiKhoan> Show() throws Throwable{
        return taiKhoanService.FindAll();
    }
}