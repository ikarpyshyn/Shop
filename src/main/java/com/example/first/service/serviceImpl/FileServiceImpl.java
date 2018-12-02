package com.example.first.service.serviceImpl;

import com.example.first.dto.MyMultipartFile;
import com.example.first.service.FileService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public void saveFile(String content) throws IOException {
        String[]arr = content.split(",");
        BASE64Decoder base64= new BASE64Decoder();
        byte[] imgContent= base64.decodeBuffer(arr[1]);
        String expansion = arr[0].split("/")[1].split(";")[0];
        String name = UUID.randomUUID().toString();
        MyMultipartFile myMultipartFile = new MyMultipartFile(imgContent,name,expansion);
        File file= new File("C:\\JAVA\\CateClub\\FrontEnd\\project CateClub");
        myMultipartFile.transferTo(file);
        file.createNewFile();
    }
}
