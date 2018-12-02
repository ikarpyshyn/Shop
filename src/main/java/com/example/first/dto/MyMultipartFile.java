package com.example.first.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class MyMultipartFile implements MultipartFile {

    private byte[] content;
    private String name;
    private String expansion;


    public MyMultipartFile(byte[] content, String name, String expansion) {
        this.content = content;
        this.name = name;
        this.expansion = expansion;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOriginalFilename() {
        return name+"."+expansion;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return content;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(content);
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {
     new FileOutputStream(file).write(content);
    }
}
