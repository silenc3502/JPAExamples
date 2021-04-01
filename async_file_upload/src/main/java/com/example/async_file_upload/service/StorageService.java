package com.example.async_file_upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public void uploadFile(MultipartFile file);
}
