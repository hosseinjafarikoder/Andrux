package com.andrux.andrux.service;



import com.andrux.andrux.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    Banner saveOrUpdate(Banner banner) ;

    void deleteById(Long id);

    Banner findById(Long id);

    List<Banner> findAll();

    List<Banner> findByStatusIs(Boolean status);

    String saveBannerImage(MultipartFile file, Long bannerId);
}
