package com.api.service;

import org.springframework.stereotype.Service;

/**
 * Created by DELL on 10/22/2018.
 */
@Service
public class UtilityService {
    public static boolean isNumber(String noiDung){
        char[] arrNoidung= noiDung.toCharArray();
        for (int i=0 ;i<arrNoidung.length;i++){
            int result= (int) arrNoidung[i];
            int check=0;
            for (int j=48;j<=57;j++) {
                if (j == result) {
                    check=1;
                    break;
                }
            }
            if(check==0) return false;
        }
        return true;
    }
}