package com.better.forme.service.GCS;

import com.better.forme.web.dto.DownloadReqDto;
import com.better.forme.web.dto.UploadReqDto;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


@Service
@RequiredArgsConstructor
public class GCSService {
    private static final String DEFAULT_GCS_URL = "https://storage.googleapis.com/";

    private final Storage storage;
    @Value("${gcp.bucket:forme-bucket}")
    private String bucketName;

    public Blob downloadFileFromGCS(DownloadReqDto downloadReqDto) {
        Blob blob = storage.get(downloadReqDto.getBucketName(), downloadReqDto.getDownloadFileName());
        blob.downloadTo(Paths.get(downloadReqDto.getLocalFileLocation()));
        return blob;
    }

    public BlobInfo uploadFileToGCS(UploadReqDto uploadReqDto) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("./upload/" + uploadReqDto.getLocalFileLocation()));
        BlobInfo blobInfo = storage.create(
                BlobInfo.newBuilder(uploadReqDto.getBucketName(), uploadReqDto.getUploadFileName())
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllAuthenticatedUsers(), Acl.Role.READER))))
                        .build(), inputStream);
        return blobInfo;
    }
    public String uploadFile(InputStream inputStream, String fileName) {
        BlobInfo blobInfo = storage.create(
                BlobInfo.newBuilder(bucketName, fileName)
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllAuthenticatedUsers(), Acl.Role.READER))))
                        .build(), inputStream);
        System.out.printf("image upload success {}", blobInfo.getBlobId());
        return DEFAULT_GCS_URL + bucketName + "/" + fileName;
    }

}
