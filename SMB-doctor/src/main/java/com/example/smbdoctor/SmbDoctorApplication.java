package com.example.smbdoctor;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;

@SpringBootApplication
@MapperScan(value = "com.example.smbdoctor.mapper")
public class SmbDoctorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmbDoctorApplication.class, args);
    }



}
