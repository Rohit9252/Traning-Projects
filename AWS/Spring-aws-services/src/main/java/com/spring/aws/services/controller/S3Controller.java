package com.spring.aws.services.controller;


import com.spring.aws.services.sevice.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class S3Controller {


    private final S3Service s3Service;

    //1. Way Using the presigned Url passed to the User, and they will upload that file
    // but we need to generate the key first, and then we can upload that file to the s3 bucket
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile() {
        URL url = s3Service.generatePresignedUrlForPutObject();

        return ResponseEntity.ok(url.toString());


    }


    @GetMapping("/view")
    public ResponseEntity<String> viewFile(@RequestParam String key) {


        URL url = s3Service.generatePresignedUrlForGetObject(key);

        return ResponseEntity.ok(url.toString());

    }


    @PostMapping("/upload/video")
    public ResponseEntity<String> uploadFile( @RequestParam("file") MultipartFile file) {
        System.out.println("Received upload request");
        String contentType = file.getContentType();
        System.out.println(contentType);
        String key = generateUniqueKey(file.getOriginalFilename());
        System.out.println(key);
        s3Service.uploadVideo(file, key);
        return ResponseEntity.ok("File uploaded successfully");
    }

    private String generateUniqueKey(String originalFilename) {
        // Implement your logic to generate a unique key, e.g., using UUID
        return UUID.randomUUID().toString() + "-" + originalFilename;
    }

}
