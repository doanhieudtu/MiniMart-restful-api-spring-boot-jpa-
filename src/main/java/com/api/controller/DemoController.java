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
    public Map<String, Object> Show() throws Throwable{
        Map<String, Object> mapData= new HashMap<>();
        List<String> ls= new ArrayList<>();
        ls.add("susscess");
        mapData.put("status",ls);
        List<TaiKhoan> lsTK= new ArrayList<>();
        lsTK=(List<TaiKhoan>) taiKhoanService.FindAll();
        mapData.put("taikhoan", lsTK.get(0));
        int maChiNhanh= lsTK.get(0).getNguoi_dung().getChiNhanh().getMachinhanh();
        mapData.put("branch", (List<ChiNhanh>) chiNhanhService.FinbyProperty("machinhanh",maChiNhanh)[0]);
        return mapData;
    }
}