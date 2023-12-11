package com.andrux.andrux.fileuploadService.service.impl;


import com.andrux.andrux.Settings;
import com.andrux.andrux.fileuploadService.service.FilesStorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

//    @Autowired
//    private BannerService bannerService;

    private final Path root = Paths.get(Settings.SAVE_BANNER_IMAGE_PATH_DIRECTORY);

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
        System.out.println("init fileService ok..."+root.toString());
    }

    @Override
    public String save(MultipartFile file, Long bannerId, String name) {
        try {
//            Files.copy(file.getInputStream(), this.root.resolve(name+"-"+bannerId+"-"+file.getOriginalFilename()));
            Files.copy(file.getInputStream(), this.root.resolve(name+"-"+bannerId+".jpg"));

//            //update banner service url :
//            Banner banner = bannerService.findById(bannerId);
//            banner.setUrl(name+"-"+bannerId);
//            bannerService.saveOrUpdate(banner);

        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
        String bannerUrl = name+"-"+bannerId+".jpg";
        return bannerUrl;
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}