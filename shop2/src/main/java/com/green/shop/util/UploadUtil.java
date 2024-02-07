package com.green.shop.util;

import com.green.shop.item.vo.ImgVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// 파일 첨부와 관련된 기능 모음집
public class UploadUtil {
    // 파일의 확장자를 문자열로 리턴하는 메소드
    public  static String getExtension(String fileName){
       return fileName.substring(fileName.lastIndexOf("."));
    }
    // uuid를 통한 파일명 생성
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
    // 단일 파일 업로드 하는 메소드
    public static ImgVO uploadFile(MultipartFile img1){
        // 첨부한 파일이 존재할 때만 실행
        ImgVO imgVO = null;
        if(!img1.isEmpty()){
            imgVO = new ImgVO();
            // 확장자 추출
            String extension = UploadUtil.getExtension(img1.getOriginalFilename());
            // 중복되지 않는 파일명 생성
            String fileName = UploadUtil.getUUID() + extension;

            try {
                File file = new File(ConstantVariable.UPLOAD_PATH + fileName);
                img1.transferTo(file);
                imgVO.setAttachedFileName(fileName);
                imgVO.setOriginFileName(img1.getOriginalFilename());
                imgVO.setIsMain("Y");
            } catch (IOException e) {
                System.out.println("파일 첨부 중 오류 발생");
                throw new RuntimeException(e);
            }

        }
        return imgVO;
    }

    // 다중 첨부 메소드
    public static List<ImgVO> multiUploadFile(MultipartFile[] img2){
        List<ImgVO> imgList = new ArrayList<>();

        for(MultipartFile mult: img2){
          ImgVO vo =  uploadFile(mult);
          if(vo != null){
              vo.setIsMain("N");
              imgList.add(vo);
            }

        }
        return imgList;
    }



}
