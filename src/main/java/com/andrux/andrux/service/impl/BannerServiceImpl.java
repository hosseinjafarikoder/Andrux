package com.andrux.andrux.service.impl;


import com.andrux.andrux.entity.Banner;
import com.andrux.andrux.fileuploadService.service.FilesStorageService;
import com.andrux.andrux.repository.BannerRepository;
import com.andrux.andrux.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    FilesStorageService storageService;

    @Override
    public Banner saveOrUpdate(Banner banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public void deleteById(Long id) {
        bannerRepository.deleteById(id);
    }

    @Override
    public Banner findById(Long id) {
        return bannerRepository.findById(id).get();
    }

    @Override
    public List<Banner> findAll() {
        return bannerRepository.findAll();
    }

    @Override
    public List<Banner> findByStatusIs(Boolean status) {
        return bannerRepository.findByStatusIs(status);
    }

    @Override
    public String saveBannerImage(MultipartFile file, Long bannerId) {
        String message = "";

        String bannerUrl = null;
        try {
            bannerUrl = storageService.save(file, bannerId, "banner");
            message = "Uploaded the banner image successfully: " + file.getOriginalFilename();
            System.err.println(message);
            //todo
//            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "Could not upload the banner image: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            System.err.println(message);
            //todo
//            model.addAttribute("message", message);
        }
        return bannerUrl;
    }

}
