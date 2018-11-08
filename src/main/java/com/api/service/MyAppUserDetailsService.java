package com.api.service;

import com.api.dao_impl.NguoiDungImpl;
import com.api.dao_impl.TaiKhoanImpl;
import com.api.model.NguoiDung;
import com.api.model.TaiKhoan;
import com.api.model.TaiKhoan_Quyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by DELL on 10/14/2018.
 */
@Service
public class MyAppUserDetailsService implements UserDetailsService {
    @Autowired
    TaiKhoanImpl taiKhoanImpl;

    @Autowired
    NguoiDungImpl nguoiDungImpl;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TaiKhoan_Quyen_Service taiKhoan_quyen_service;

    @Autowired
    TaiKhoanService taiKhoanService;
    @Override
    public UserDetails loadUserByUsername(String tenTK) throws UsernameNotFoundException {
        List<TaiKhoan> lsTaiKhoan= new ArrayList<>();
        lsTaiKhoan=(List<TaiKhoan>) taiKhoanService.FinbyProperty("tenTK", tenTK)[0];
        TaiKhoan taiKhoan= lsTaiKhoan.get(0);
        if(taiKhoan!= null){
            List<String> role= new ArrayList<>();
            List<TaiKhoan_Quyen> lsTaiKhoan_quyens= new ArrayList<>();
            lsTaiKhoan_quyens=(List<TaiKhoan_Quyen>) taiKhoan_quyen_service.FinbyProperty("taiKhoan.maTK",taiKhoan.getMaTK())[0];
            lsTaiKhoan_quyens.forEach(taiKhoan_quyen -> role.add(taiKhoan_quyen.getPhanQuyen().getVaitro()));
            GrantedAuthority authority=
                    new SimpleGrantedAuthority(role.toArray(new String[role.size()]).toString());
            UserDetails userDetails= (UserDetails)
                    new User(taiKhoan.getTenTK()
                            ,taiKhoan.getMatKhau(), Arrays.asList(authority));
            return  userDetails;
        }
       return null;
    }
}