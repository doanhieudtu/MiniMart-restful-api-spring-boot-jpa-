package com.api.controller;

import com.api.model.ChiNhanh;
import com.api.model.NguoiDung;
import com.api.model.TaiKhoan;
import com.api.service.ChiNhanhService;
import com.api.service.NguoiDungService;
import com.api.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 09/17/2018.
 */
@RestController
@RequestMapping("/tai-khoan/")
public class TaiKhoanController {
    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    ChiNhanhService chiNhanhService;

    @Autowired
    NguoiDungService nguoiDungService;

    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("dang-nhap")
    public TaiKhoan DangNhap(@RequestParam String tenTK , String matKhau){
        List<TaiKhoan> lsTaiKhoan= new ArrayList<>();
        try {
            lsTaiKhoan=(List<TaiKhoan>) taiKhoanService.FinbyProperty("tenTK", tenTK)[0];
            for (TaiKhoan tk: lsTaiKhoan) {
                //kiểm tra mã hóa có nội dung với mật khảu người nhập
                if(passwordEncoder.matches(matKhau,tk.getMatKhau())== true)
                {
                    return  tk;
                }
            }
        }catch (Exception e){throw e;}
        return  null;
    }
    @POST
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("nguoi-dung")
    public NguoiDung getNguoiDung(@RequestParam String maTK ){
       try {
           List<NguoiDung> lsNguoiDungs= new ArrayList<>();
           lsNguoiDungs=(List<NguoiDung>) nguoiDungService.FinbyProperty("taiKhoan.maTK", Integer.parseInt(maTK))[0];
           return lsNguoiDungs.get(0);
       }
       catch (Exception e){}
        return  null;
    }
    @POST
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("chi-nhanh")
    public ChiNhanh getChiNhanh(@RequestParam String maTK ){
        try {
            List<NguoiDung> lsNguoiDungs= new ArrayList<>();
            lsNguoiDungs=(List<NguoiDung>) nguoiDungService.FinbyProperty("taiKhoan.maTK", Integer.parseInt(maTK))[0];
            return lsNguoiDungs.get(0).getChiNhanh();
        }
        catch (Exception e){}
        return  null;
    }


}