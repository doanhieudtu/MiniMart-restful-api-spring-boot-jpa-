package com.api.controller;

import com.api.model.*;
import com.api.service.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.invoke.util.VerifyAccess;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DELL on 12/20/2018.
 */

@RestController
@RequestMapping("/don-hang/")
public class DonHangController {


    public  String[] splitToken(String token){ return  token.split(":");}
    @Autowired
    DonHangService donHangService;

    @Autowired
    MatHangService matHangService;

    @Autowired
    MatHang_ChiNhanh_Service matHang_chiNhanh_service;

    @Autowired
    NguoiDungService nguoiDungService;

    @Autowired
    ChiTietDonHangService chiTietDonHangService;
    @PostMapping("tao-moi")
    public int CreateBill(@RequestParam String idProduct, String countProduct, String manv
            , String chietkhau,  String ghichu, String vat) throws IOException{
        try {
                    /*get list id product*/

            List<ItemBill> itemBills1= new ArrayList<>();
            String[] arrID = splitToken(idProduct);
            String[] arrCount = splitToken(countProduct);
            for(int i=0;i<arrCount.length;i++){
                itemBills1.add(new ItemBill(arrID[i], Integer.parseInt(arrCount[i])));
            }
            itemBills1.forEach(s-> System.out.println(s.getMaSP()+s.getSoLuong()) );
            List<MatHang_ChiNhanh> lsMatHang= new ArrayList<>();
            for ( ItemBill id: itemBills1) {
                List<MatHang_ChiNhanh> ls= new ArrayList<>();
                ls=(List<MatHang_ChiNhanh>) matHang_chiNhanh_service.FinbyProperty("ma_Mathang_chiNhanh", Integer.parseInt(id.getMaSP()))[0];
                lsMatHang.add(ls.get(0));
            }
        /*get list product*/
        /*get craeter bill*/
            List<NguoiDung> lsNV= new ArrayList<> ();
            lsNV=(List<NguoiDung>)nguoiDungService.FinbyProperty("maND", Integer.parseInt(manv))[0];
        /*get craeter bill*/
        /*create bill*/
            DonHang donHang= new DonHang();
            donHang.setChietKhau(Float.parseFloat(chietkhau));
            donHang.setVat(Double.parseDouble(vat));
            donHang.setChiNhanh(lsNV.get(0).getChiNhanh());
            donHang.setNgaylap(new Date());
            donHang.setNguoiDung(lsNV.get(0));
            donHang.setGhiChu(ghichu);
            donHangService.Add(donHang);
        /*create bill*/
        /*create detail bill*/
            List<DonHang> lsDonHangall= new ArrayList<>();
            lsDonHangall=(List<DonHang>) donHangService.FindAll();
            donHang= lsDonHangall.get(lsDonHangall.size()-1)/*get DonHang created*/;
            List<ChiTietDonHang> lsChiTietDonHangs= new ArrayList<>();
            for (ItemBill item: itemBills1) {
                ChiTietDonHang chiTietDonHang= new ChiTietDonHang();
                chiTietDonHang.setDonHang(donHang);
                lsMatHang= (List<MatHang_ChiNhanh>) matHang_chiNhanh_service.FinbyProperty("ma_Mathang_chiNhanh",Integer.parseInt(item.getMaSP()) )[0];
                MatHang_ChiNhanh mh=  new MatHang_ChiNhanh();
                mh=lsMatHang.get(0);
                chiTietDonHang.setMatHang_chiNhanh(lsMatHang.get(0));
                chiTietDonHang.setSoLuong(item.getSoLuong());
                chiTietDonHangService.Add(chiTietDonHang);
                lsChiTietDonHangs.add(chiTietDonHang);
                mh.setSoLuongDangBan(mh.getSoLuongDangBan()- item.getSoLuong());
                matHang_chiNhanh_service.Update(mh);
            }

            donHangService.Update(donHang);
        /*create detail bill*/
            return  1;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("danh-sach-trong-ngay")
    public List<DonHang> getBillinDate(@RequestParam String idbranch){
        if(!idbranch.isEmpty()){
            List<DonHang> result= new ArrayList<>();
            List<DonHang> getAll= new ArrayList<>();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//            try {
                getAll=(List<DonHang>) donHangService.FinbyProperty("chiNhanh.machinhanh",Integer.parseInt(idbranch))[0];
                result= getAll.stream().filter(item->
                       sdf.format(item.getNgaylap()).compareTo(sdf.format(new Date()))==0
                ).collect(Collectors.toList());
                return  result;
//            }
//            catch (Exception e){throw  e;}
        }
        return null;
    }
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PostMapping("chi-tiet-don-hang")
    public List<ChiTietDonHang> getDetailBill(@RequestParam String idBill){
        if(!idBill.isEmpty()){
            List<ChiTietDonHang> result= new ArrayList<>();
            try {
                result=(List<ChiTietDonHang>) chiTietDonHangService.FinbyProperty("donHang.madonhang", Integer.parseInt(idBill))[0];
                return result;
            }catch (Exception e){throw  e;}
        }
        return null;
    }
}