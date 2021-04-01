package com.example.async_file_upload.service;

import com.example.async_file_upload.exception.StorageException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Value("${upload.path}")
    private String path;

    public void uploadFile(MultipartFile file) {

        if (file.isEmpty()) {

            throw new StorageException("Failed to store empty file");
        }

        try {
            var fileName = file.getOriginalFilename();
            var is = file.getInputStream();

            Files.copy(is, Paths.get(path + fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

            var msg = String.format("Failed to store file %f", file.getName());

            throw new StorageException(msg, e);
        }
    }
}
