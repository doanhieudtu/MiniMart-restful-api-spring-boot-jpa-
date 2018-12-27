package com.api.controller;

import com.api.model.MatHang_ChiNhanh;
import com.api.model.NhaCC_MatHang;
import com.api.model.NhaCungCap;
import com.api.service.MatHang_ChiNhanh_Service;
import com.api.service.NhaCungCap_MatHang_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DELL on 12/25/2018.
 */
@RestController
@RequestMapping("/loai-hang/")
public class LoaiHangController {

    @Autowired
    MatHang_ChiNhanh_Service matHang_chiNhanh_service;

    @Autowired
    NhaCungCap_MatHang_Service nhaCungCap_matHang_service;

    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("mat-hang-chi-nhanh")
    public List<MatHang_ChiNhanh>getCategoryBranch(@RequestParam String idbranch, String idcategory){
        try {
            List<MatHang_ChiNhanh> getAll= matHang_chiNhanh_service.FindAll();
            List<MatHang_ChiNhanh> result= new ArrayList<>();
            result= getAll.stream().filter(item
                    -> item.getMatHang().getLoaihang().getMaloai()== Integer.parseInt(idcategory)
                    && item.getChiNhanh().getMachinhanh()== Integer.parseInt(idbranch)
            ).collect(Collectors.toList());
            if(result.size()>0) return  result;
        }catch (Exception e){throw  e;}
        return null;
    }
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("nha-cung-cap")
    public NhaCungCap getNhaCC(@RequestParam String idProduct){
        try {
            List<NhaCC_MatHang> result= new ArrayList<>();
            result=(List<NhaCC_MatHang>) nhaCungCap_matHang_service.FinbyProperty("matHang.mahang", idProduct)[0];
            if(result.size()>0) return  result.get(0).getNhaCungCap();
        }catch (Exception e){throw  e;}
        return null;
    }
}