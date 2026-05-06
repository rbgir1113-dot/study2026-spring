package com.app.oauth.service;


import com.app.oauth.domain.dto.response.ApiResponseDTO;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.util.List;

public interface FileService {
    public ApiResponseDTO uploadFile(MultipartFile uploadFile);

    public ApiResponseDTO uploadFiles(List<MultipartFile> uploadFiles);

    public ResponseBytes<GetObjectResponse> getDisplayPath(String fileName);
}
