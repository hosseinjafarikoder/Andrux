package com.andrux.andrux.fileuploadService.controller;


import com.andrux.andrux.fileuploadService.model.ImageInfo;
import com.andrux.andrux.fileuploadService.service.FilesStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    @Autowired
    FilesStorageService storageService;



    @GetMapping("/")
    public String homepage() {
        return "redirect:/image/images";
    }

    @GetMapping("/images/new")
    public String newImage(Model model) {
        return "fileUploadService/th_upload_form";
    }

    @PostMapping("/images/upload")
    public String uploadImage(Model model, @RequestParam("file") MultipartFile file) {
        String message = "";

        try {
            //todo i set bannerId null for remove compileTime error , later i check and fix it:
            storageService.save(file,null,"main");
            message = "Uploaded the image successfully: " + file.getOriginalFilename();
            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "Could not upload the image: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            model.addAttribute("message", message);
        }

        return "fileUploadService/th_upload_form";
    }

    @GetMapping("/images")
    public String getListImages(Model model) {
        List<ImageInfo> imageInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(ImageController.class, "getImage", path.getFileName().toString()).build().toString();

            return new ImageInfo(filename, url);
        }).collect(Collectors.toList());

        model.addAttribute("images", imageInfos);

//        return "fileUploadService/th_images";
        return null;
    }

    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/images/delete/{filename:.+}")
    public String deleteImage(@PathVariable String filename, Model model, RedirectAttributes redirectAttributes) {
        try {
            boolean existed = storageService.delete(filename);

            if (existed) {
                redirectAttributes.addFlashAttribute("message", "Delete the image successfully: " + filename);
            } else {
                redirectAttributes.addFlashAttribute("message", "The image does not exist!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                    "Could not delete the image: " + filename + ". Error: " + e.getMessage());
        }

        return "redirect:/image/images";
    }
}