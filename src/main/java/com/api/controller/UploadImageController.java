package com.api.controller;

import com.api.service.ConvertImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by DELL on 10/26/2018.
 */
@RestController
@RequestMapping("/image/")
public class UploadImageController {

@RequestMapping(value = "uploadFile", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
    String path= "E:/project/mini_mart/src/main/resources/Image/";
    File uploadedFile = new File(path, file.getOriginalFilename());
    System.out.println(file.getOriginalFilename());
    try {
        uploadedFile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return new ResponseEntity<Object>("file Uplaoded succesfully", HttpStatus.OK);
}
    //method for downloading file
    @RequestMapping(value = "downloadFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Object> downloadFile(@RequestParam String fileName) {

        String filePath = "E:/project/mini_mart/src/main/resources/Image/" + fileName;
        Path path = Paths.get(filePath);
        Resource resource = null;

        try {
            resource= new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (resource.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

            // return new ResponseEntity<Object>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("File Not Found ", HttpStatus.OK);
        }
    }

}