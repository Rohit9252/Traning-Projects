package com.spring.aws.services.sevice;


import com.amazonaws.AmazonClientException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Service
public class S3Service {

    @Value("${aws.s3.bucket}")
    private String bucketName;


    private final AmazonS3 s3Client;

    @Autowired
    public S3Service(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }



    // It will generate the presigned URL for the user to upload the file
    // user have to upload the file using this URL
    public URL generatePresignedUrlForPutObject() {
        Date expiration = new Date();
        expiration.setTime(expiration.getTime() + 3600000); // Set expiration time to 1 hour

        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, "/user/users-upload"+ UUID.randomUUID().toString());
        request.setMethod(HttpMethod.PUT);
        request.setExpiration(expiration);

        return s3Client.generatePresignedUrl(request);
    }


    // It will generate the presigned URL for the user to view the file
    // user have to view the file using this URL
    public URL generatePresignedUrlForGetObject(String key) {
        Date expiration = new Date();
        expiration.setTime(expiration.getTime() + 3600000); // Set expiration time to 1 hour

        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, key);
        request.setExpiration(expiration);

        return s3Client.generatePresignedUrl(request);
    }

//     It will upload the video to the S3 bucket
//     first it will generate the key and then upload the video to the S3 bucket
    public void uploadVideo(MultipartFile file, String key) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());

        try {
            s3Client.putObject(bucketName, key, file.getInputStream(), metadata);
        } catch (IOException e) {
            throw new AmazonClientException("Failed to upload video to S3", e);
        }


    }




}
