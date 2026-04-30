package com.app.oauth.service;


import com.app.oauth.domain.dto.response.ApiResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    public ApiResponseDTO uploadFile(MultipartFile uploadFile);

    public ApiResponseDTO uploadFiles(List<MultipartFile> uploadFiles);

    public byte[] getDisplayPath(String fileName);
}
