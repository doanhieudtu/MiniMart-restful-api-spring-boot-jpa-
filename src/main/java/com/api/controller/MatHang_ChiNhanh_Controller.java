package com.api.controller;

import com.api.model.MatHang;
import com.api.model.MatHang_ChiNhanh;
import com.api.service.MatHang_ChiNhanh_Service;
import com.api.service.UtilityService;
import org.apache.tomcat.jni.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by DELL on 10/22/2018.
 */
@RestController
@RequestMapping("/mat-hang-chi-nhanh/")
public class MatHang_ChiNhanh_Controller {
    @Autowired
    MatHang_ChiNhanh_Service matHang_chiNhanh_service;

    @Autowired
    UtilityService utilityService;


    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RequestMapping("danh-sach")
    public ArrayList<MatHang_ChiNhanh> DanhSach(@RequestParam String  maChinhanh)
    {
        return (ArrayList<MatHang_ChiNhanh>) matHang_chiNhanh_service.FinbyProperty("chiNhanh.machinhanh",Integer.parseInt(maChinhanh))[0];
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("tim-kiem")
    public List<MatHang_ChiNhanh> TimKiem(@RequestParam String maChinhanh, String noiDung){
       List<MatHang_ChiNhanh> lsMathangChinhanh= new ArrayList<>();
        if(utilityService.isNumber(noiDung)==true){
                lsMathangChinhanh =(List<MatHang_ChiNhanh>) matHang_chiNhanh_service
                        .FinbyProperty("chiNhanh.machinhanh", Integer.parseInt(maChinhanh))[0];
                if(lsMathangChinhanh!=null){
                    List<MatHang_ChiNhanh> end= new ArrayList<>();
                    end=lsMathangChinhanh.stream().filter(
                            matHang_chiNhanh -> matHang_chiNhanh
                                    .getMa_Mathang_chiNhanh()==Integer.parseInt(noiDung)).collect(Collectors.toList());
                    return end;

                }
        }
        else {
               lsMathangChinhanh=(List<MatHang_ChiNhanh>) matHang_chiNhanh_service.FindContentLike(Integer.parseInt(maChinhanh), noiDung);
               if(lsMathangChinhanh!=null) {
                    return lsMathangChinhanh;
               }
        }
        return null;
    }
    @RequestMapping(value = "dong-bo-anh" ,method = RequestMethod.GET)
    public ArrayList<String> DongBoAnh(@RequestParam String maChinhanh) {
        List<MatHang_ChiNhanh> matHang_chiNhanhList = new ArrayList<>();
        matHang_chiNhanhList = (List<MatHang_ChiNhanh>) matHang_chiNhanh_service
                .FinbyProperty("chiNhanh.machinhanh", Integer.parseInt(maChinhanh))[0];
        List<String> lsFilename= new ArrayList<>();
        matHang_chiNhanhList.forEach(item->{
            if(item.isDongBoanh()==false){
                lsFilename.add(item.getMatHang().getHinhAnh());
                item.setDongBoanh(true);
                matHang_chiNhanh_service.Update(item);
            }
        });
        return (ArrayList<String>) lsFilename;
    }
}