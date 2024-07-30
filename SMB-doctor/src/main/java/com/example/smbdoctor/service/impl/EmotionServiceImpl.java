package com.example.smbdoctor.service.impl;

import com.example.smbdoctor.service.EmotionService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class EmotionServiceImpl implements EmotionService {
    @Override
    public String getEmotionData(String url) {

        String re = "";
        //String url = "https://636c-cloud1-9guju9ls5a0e3266-1322543279.tcb.qcloud.la/tmp/face_emotion.png";
        try {
//            String[] command = new String[]{
//                    "/usr/venv//bin/python",
//                    "/usr/test.py",
//                    url
//            };
            String[] command = new String[]{"D:\\Ide\\python\\pyCharm\\resource\\test\\.venv\\Scripts\\python.exe", "D:\\Ide\\python\\pyCharm\\resource\\test\\pp.py", url};

            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // 设置环境变量
//            Map<String, String> env = processBuilder.environment();
//            env.put("PYTHONPATH", "D:\\Ide\\python\\pyCharm\\resource\\test\\.venv\\Lib\\site-packages");

            Process proc = processBuilder.start();

            // Read standard output
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            // Read standard error
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

            String s;
            System.out.println("Standard output:");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                re += s;
            }

            System.out.println("Standard error:");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            int exitVal = proc.waitFor();
            System.out.println("Process exit value: " + exitVal);

            stdInput.close();
            stdError.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return re;
    }

}

