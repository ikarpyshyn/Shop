package com.example.first.controller;


import com.example.first.dto.FileRequest;
import com.example.first.service.FileService;
import com.example.first.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void saveFile(@RequestBody FileRequest content) throws IOException {
     fileService.saveFile(content.getContent());
    }
}
