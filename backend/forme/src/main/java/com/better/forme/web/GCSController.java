package com.better.forme.web;


import com.better.forme.service.GCS.GCSService;
import com.better.forme.web.dto.DownloadReqDto;
import com.better.forme.web.dto.UploadReqDto;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ResponseMessage;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GCSController {

    private final GCSService gcsService;

    @PostMapping("/gcs/download")
    public ResponseEntity localDownloadFromStorage(@RequestBody DownloadReqDto downloadReqDto){
        Blob fileFromGCS = gcsService.downloadFileFromGCS(downloadReqDto);
        return ResponseEntity.ok(fileFromGCS.toString());
    }

    @PostMapping("gcs/upload")
    public ResponseEntity localUploadToStorage(@RequestBody UploadReqDto uploadReqDto) throws IOException {
        BlobInfo fileFromGCS = gcsService.uploadFileToGCS(uploadReqDto);
        return ResponseEntity.ok(fileFromGCS.toString());
    }
}
