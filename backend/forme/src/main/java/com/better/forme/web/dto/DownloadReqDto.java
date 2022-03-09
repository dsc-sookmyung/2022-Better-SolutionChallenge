package com.better.forme.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DownloadReqDto {
    private String bucketName;
    private String downloadFileName;
    private String localFileLocation;
}