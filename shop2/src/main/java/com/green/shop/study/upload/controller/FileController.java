package com.green.shop.study.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping("/uploadForm")
    public String uploadForm(){

        String file1 = "abc.jpg";
        System.out.println(file1.substring(1,5));

        System.out.println(file1.indexOf("."));
        System.out.println(file1.lastIndexOf("."));
        System.out.println(file1.substring(file1.lastIndexOf("."),file1.lastIndexOf("g")+1));



        return "test/upload/upload_form";

    }
    // 파일 업로드
    @PostMapping("/upload")
    public String upload(@RequestParam(name="img1") MultipartFile img1,
                        @RequestParam(name="img2") MultipartFile img2){
        // 첨부한 파일명
       String fileName = img1.getOriginalFilename();
        System.out.println(fileName);

        // 업로드 경로
        String uploadPath = "D:\\01-STUDY\\dev\\worksprace_sts\\shop\\src\\main\\resources\\static\\upload\\";

        // 특수문자를 문자열로 취급하기 위해
        // 특수문자 앞에 \를 붙여주면 됨

        // 업로드 할 경로 및 파일 명을 하나의 문자열로 나열
        String fileNames = uploadPath + fileName;
        // 파일 업로드

        try {
            File file = new File(fileNames);
            img1.transferTo(file);
        } catch (IOException e) {
            System.out.println("파일 첨부 중 오류 발생");
            throw new RuntimeException(e);
        }

        // 두 번째 파일을 업로드
        // 원본 파일의 확장자만 추출
        String secondFileName = img2.getOriginalFilename();
         String extension = secondFileName.substring(secondFileName.lastIndexOf("."));

        // 서버에 저장 할 파일명 생성
        String uuid = UUID.randomUUID().toString();
        String attachedfileName = uuid + extension;




        try {
            File file1 = new File(uploadPath + attachedfileName);
            img2.transferTo(file1);
        } catch (IOException e) {
            System.out.println("파일 첨부 중 오류 발생");
            throw new RuntimeException(e);
        }


        return "";
    }

    // 다중 첨부
    @GetMapping("/multiForm")
    public String multiForm(){
        return "test/upload/multi_form";

    }
    @PostMapping("multi")
    public String multi(@RequestParam(name = "imgs") MultipartFile[] imgs){
        // 첨부할 파일 경로
        String uploadPath = "D:\\01-STUDY\\dev\\worksprace_sts\\shop\\src\\main\\resources\\static\\upload\\";

        for(MultipartFile img: imgs){

            System.out.println(img.getOriginalFilename());
            //확장자 추출
            String extension = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));

            //첨부 될 파일 명
            String attachedFiledName = UUID.randomUUID().toString() + extension;


            try {
                File file = new File(uploadPath + attachedFiledName);
                img.transferTo(file);
            } catch (IOException e) {
                System.out.println("파일 첨부 중 오류 발생");
                throw new RuntimeException(e);
            }


        }




        return "";
    }

}
