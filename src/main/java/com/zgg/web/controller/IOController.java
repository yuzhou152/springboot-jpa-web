package com.zgg.web.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/IOController")
public class IOController {
    @RequestMapping(value="/tohtml",method = RequestMethod.GET)
    public String home(HttpServletRequest req){
    	return "test";
    }
    @RequestMapping(value="/toUpload",headers = "Content-Type=multipart/form-data",method = RequestMethod.POST)
    public String upload(@RequestParam("textfileddd")MultipartFile  textfile){
      try {
    		new BufferedReader(new InputStreamReader(textfile.getInputStream())).lines().forEach(line -> {
    			System.out.println(line);
    		});
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return "test";
    }
    
    @RequestMapping(value="/toDownload")
    public void download(HttpServletRequest request,HttpServletResponse response) {
    	try (ServletOutputStream outp =  response.getOutputStream();
    			InputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\++.xlsx");	) {
    		
            byte[] b = new byte[1024];
            int i = 0;

            while ((i = in.read(b)) > 0) {
                outp.write(b, 0, i);
            }
            outp.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("successfully!");
		}
    }

}
