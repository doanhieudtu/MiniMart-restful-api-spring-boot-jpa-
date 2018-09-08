package com.api.controller;

import com.api.model.*;
import com.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @ResponseBody
    @RequestMapping("ls-nguoi-dung")
    public List<TaiKhoan> Show(){
        return taiKhoanService.FindAll();
    }
}