package com.example.smbdoctor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smbdoctor.config.TesseractTemplate;
import com.example.smbdoctor.entity.MedicationInfo;
import com.example.smbdoctor.service.MedicationInfoService;
import com.example.smbdoctor.mapper.MedicationInfoMapper;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
* @author liushizhan
* @description 针对表【medication_info】的数据库操作Service实现
* @createDate 2024-06-08 11:20:07
*/
@Service
public class MedicationInfoServiceImpl extends ServiceImpl<MedicationInfoMapper, MedicationInfo>
    implements MedicationInfoService {


    @Autowired
    TesseractTemplate tesseractTemplate;

    @Autowired
    MedicationInfoMapper mapper;
    @Override
    public void addMedication(MedicationInfo medicationInfo) {

        mapper.insert(medicationInfo);

    }


    public String processImage(String imageURL){
        String imageUrl = "https://example.com/image.jpg";
        String outputPath = "D:\\local_image.png";

        String imageContent = null;

        try {
            // Download image from URL
            URL url = new URL("https://636c-cloud1-9guju9ls5a0e3266-1322543279.tcb.qcloud.la/tmp/face_emotion.png");
            BufferedImage image = ImageIO.read(url);

            // Save image to local file
            File outputFile = new File("D:\\local_image.png");
            ImageIO.write(image, "png", outputFile);

            System.out.println("Image downloaded and saved successfully.");

            // Process the image here
            imageContent = tesseractTemplate.doOCR(imageURL);
            //     Delete the image
            Files.deleteIfExists(Paths.get("D:\\local_image.png"));

            System.out.println("Image deleted successfully.");

        } catch (IOException | TesseractException e) {
            System.out.println("Error downloading or saving image: " + e.getMessage());
        }

        return imageContent;

    }
}




