//package com.example.smbdoctor;
//
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import org.junit.jupiter.api.Test;
//import org.opencv.core.*;
//import org.opencv.features2d.BFMatcher;
//import org.opencv.features2d.Features2d;
//import org.opencv.features2d.ORB;
//import org.opencv.highgui.HighGui;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.python.core.*;
//import org.python.util.PythonInterpreter;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//
//import org.opencv.core.Mat;
//
//
//
//@SpringBootTest
//class SmbDoctorApplicationTests {
//
//    @Test
//    void contextLoads() throws TesseractException {
//
//        long start = System.currentTimeMillis();
//        System.out.println("开始OCR文字识图，请稍后...");
//        //加载要识别的图片
//        File image = new File("D:\\hahaha.png");
//        //设置配置文件夹微视、识别语言、识别模式
//        Tesseract tesseract = new Tesseract();
//        tesseract.setDatapath("src/main/resources/tessdata");
//        //设置识别语言为中文简体，（如果要设置为英文可改为"eng"）
//        tesseract.setLanguage("chi_sim");
//        //使用 OSD 进行自动页面分割以进行图像处理
//        tesseract.setPageSegMode(1);
//        //设置引擎模式是神经网络LSTM引擎
//        tesseract.setOcrEngineMode(1);
//        //开始识别整张图片中的文字
//        String result = tesseract.doOCR(image);
//        long time = System.currentTimeMillis()-start;
//        System.out.println("识别结束,耗时："+time+" 毫秒，识别结果如下：");
//        System.out.println();
//        System.out.println(result);
//
//    }
//
//    @Test
//    void testDownloadImage(){
//        String imageUrl = "https://example.com/image.jpg";
//        String outputPath = "local_image.jpg";
//
//        try {
//            // Download image from URL
//            URL url = new URL("https://636c-cloud1-9guju9ls5a0e3266-1322543279.tcb.qcloud.la/tmp/face_emotion.png");
//            BufferedImage image = ImageIO.read(url);
//
//            // Save image to local file
//            File outputFile = new File("D:\\local_image.png");
//            ImageIO.write(image, "png", outputFile);
//
//            System.out.println("Image downloaded and saved successfully.");
//
//            // Process the image here
//
//            // Delete the image
////            Files.deleteIfExists(Paths.get(outputPath));
////
////            System.out.println("Image deleted successfully.");
//
//        } catch (IOException e) {
//            System.out.println("Error downloading or saving image: " + e.getMessage());
//        }
//    }
//
//
//    @Test
//    void emotion(){
//
//                PythonInterpreter interpreter = new PythonInterpreter();
//                interpreter.execfile("D:\\Ide\\python\\pyCharm\\resource\\test\\pp.py");
//
//                // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
//                PyFunction pyFunction = interpreter.get("add", PyFunction.class);
//
//                String url = "https://636c-cloud1-9guju9ls5a0e3266-1322543279.tcb.qcloud.la/tmp/face_emotion.png";
//                PyObject pyUrl = Py.java2py(url);
//                //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
//                PyObject pyobj = pyFunction.__call__(pyUrl);
//                System.out.println("the anwser is: " + pyobj);
//
//    }
//
//    //ocr
//    @Test
//    void testpython() {
//
//        int a = 18;
//        int b =7;
//        String url = "https://636c-cloud1-9guju9ls5a0e3266-1322543279.tcb.qcloud.la/tmp/face_emotion.png";
//        try {
//            String[] args = new String[]{"D:\\Ide\\python\\pyCharm\\resource\\test\\.venv\\Scripts\\python.exe", "D:\\Ide\\python\\pyCharm\\resource\\test\\pp.py", url};
//            Process proc = Runtime.getRuntime().exec(args);// 执行py文件
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            proc.waitFor();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }
//    }
//
//    static{
//       // System.loadLibrary("C:\\Users\\liushizhan\\Downloads\\opencv\\build\\java\\x64\\opencv_java4100.dll");
//        System.load("C:\\Users\\liushizhan\\Downloads\\opencv\\build\\java\\x64\\opencv_java4100.dll");
//
//    }
//    //图像匹配
//    @Test
//    void testimage(){
//        //MBFImage image = ImageUtilities.readMBF(new URL("http://static.openimaj.org/media/tutorial/sinaface.jpg"));
//        Mat img1 = Imgcodecs.imread("D:\\hehe.png", Imgcodecs.IMREAD_GRAYSCALE);
//        Mat img2 = Imgcodecs.imread("D:\\hahaha.png", Imgcodecs.IMREAD_GRAYSCALE);
//
//        if (img1.empty() || img2.empty()) {
//            System.out.println("Could not load images");
//            return;
//        }
//
//        // 检测和描述特征点
//        ORB orb = ORB.create();
//        MatOfKeyPoint keypoints1 = new MatOfKeyPoint(), keypoints2 = new MatOfKeyPoint();
//        Mat descriptors1 = new Mat(), descriptors2 = new Mat();
//
//        orb.detectAndCompute(img1, new Mat(), keypoints1, descriptors1);
//        orb.detectAndCompute(img2, new Mat(), keypoints2, descriptors2);
//
//        // 特征匹配
//        BFMatcher bfMatcher = BFMatcher.create(Core.NORM_HAMMING, true);
//        MatOfDMatch matches = new MatOfDMatch();
//        bfMatcher.match(descriptors1, descriptors2, matches);
//
//        // 筛选匹配点
//        List<DMatch> matchList = matches.toList();
//        double maxDist = 0;
//        double minDist = 100;
//
//        for (DMatch match : matchList) {
//            double dist = match.distance;
//            if (dist < minDist) minDist = dist;
//            if (dist > maxDist) maxDist = dist;
//        }
//
//        // 仅保留优质匹配
////        List<DMatch> goodMatches = new LinkedList<>();
////        for (DMatch match : matchList) {
////            if (match.distance <= Math.max(2 * minDist, 30.0)) {
////                goodMatches.add(match);
////            }
////        }
//
//        // 调整匹配保留标准，这里保留大部分匹配点
//        double threshold = Math.max(3 * minDist, 50.0);
//
//        List<DMatch> goodMatches = new ArrayList<>();
//        for (DMatch match : matchList) {
//            if (match.distance <= threshold) {
//                goodMatches.add(match);
//            }
//        }
//
//        MatOfDMatch goodMatchesMat = new MatOfDMatch();
//        goodMatchesMat.fromList(goodMatches);
//
//        // 绘制匹配结果
//        Mat imgMatches = new Mat();
//        Features2d.drawMatches(img1, keypoints1, img2, keypoints2, goodMatchesMat, imgMatches);
//
//        // 保存匹配图像到文件
//        Imgcodecs.imwrite("D:\\matches.jpg", imgMatches);
//        System.out.println("Matches saved to matches.jpg");
//
//    }
//
//    @Test
//    void testbestMatches(){
//        // 读取输入图片和三张比较图片
//        String[] imagePaths = {"D:\\hehe.png", "D:\\heihei.png", "D:\\hahaha.png"};
//        Mat inputImage = Imgcodecs.imread("D:\\hh.png", Imgcodecs.IMREAD_GRAYSCALE);
//
//        if (inputImage.empty()) {
//            System.out.println("Could not load input image");
//            return;
//        }
//
//        ORB orb = ORB.create();
//        MatOfKeyPoint inputKeypoints = new MatOfKeyPoint();
//        Mat inputDescriptors = new Mat();
//        orb.detectAndCompute(inputImage, new Mat(), inputKeypoints, inputDescriptors);
//
//        double bestMatchScore = Double.MAX_VALUE;
//        String bestMatchImage = "";
//        for (String imagePath : imagePaths) {
//            Mat img = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);
//
//            if (img.empty()) {
//                System.out.println("Could not load image: " + imagePath);
//                continue;
//            }
//
//            MatOfKeyPoint keypoints = new MatOfKeyPoint();
//            Mat descriptors = new Mat();
//            orb.detectAndCompute(img, new Mat(), keypoints, descriptors);
//
//            BFMatcher bfMatcher = BFMatcher.create(Core.NORM_HAMMING, true);
//            MatOfDMatch matches = new MatOfDMatch();
//            bfMatcher.match(inputDescriptors, descriptors, matches);
//
//            List<DMatch> matchList = matches.toList();
//            double totalDistance = 0;
//            for (DMatch match : matchList) {
//                totalDistance += match.distance;
//            }
//
//            double averageDistance = totalDistance / matchList.size();
//            System.out.println("Matching score with " + imagePath + ": " + averageDistance);
//
//            if (averageDistance < bestMatchScore) {
//                bestMatchScore = averageDistance;
//                bestMatchImage = imagePath;
//            }
//        }
//
//        System.out.println("Best match is " + bestMatchImage + " with a score of " + bestMatchScore);
//    }
//
//
//    @Test
//    void testpointbestMathes(){
//        // 读取输入图片和三张比较图片
//        String[] imagePaths = {"D:\\hehe.png", "D:\\heihei.png", "D:\\hahaha.png"};
//        Mat inputImage = Imgcodecs.imread("D:\\haha.jpg", Imgcodecs.IMREAD_GRAYSCALE);
//
//        if (inputImage.empty()) {
//            System.out.println("Could not load input image");
//            return;
//        }
//
//        ORB orb = ORB.create();
//        MatOfKeyPoint inputKeypoints = new MatOfKeyPoint();
//        Mat inputDescriptors = new Mat();
//        orb.detectAndCompute(inputImage, new Mat(), inputKeypoints, inputDescriptors);
//
//        int bestMatchCount = 0;
//        String bestMatchImage = "";
//        for (String imagePath : imagePaths) {
//            Mat img = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);
//
//            if (img.empty()) {
//                System.out.println("Could not load image: " + imagePath);
//                continue;
//            }
//
//            MatOfKeyPoint keypoints = new MatOfKeyPoint();
//            Mat descriptors = new Mat();
//            orb.detectAndCompute(img, new Mat(), keypoints, descriptors);
//
//            BFMatcher bfMatcher = BFMatcher.create(Core.NORM_HAMMING, true);
//            MatOfDMatch matches = new MatOfDMatch();
//            bfMatcher.match(inputDescriptors, descriptors, matches);
//
//            List<DMatch> matchList = matches.toList();
//            int matchCount = matchList.size();
//
//            System.out.println("Matching points count with " + imagePath + ": " + matchCount);
//
//            if (matchCount > bestMatchCount) {
//                bestMatchCount = matchCount;
//                bestMatchImage = imagePath;
//            }
//        }
//
//        System.out.println("Best match is " + bestMatchImage + " with " + bestMatchCount + " matching points");
//    }
//    }
//
//
//
//
