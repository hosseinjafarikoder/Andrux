package com.andrux.andrux.controller;


import com.andrux.andrux.entity.Banner;
import com.andrux.andrux.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/banner")
@RequiredArgsConstructor
public class BannerController {

    @Autowired
    private BannerService bannerService;

    //Banner
    @GetMapping("/banner/list")
    public String listBanner(Model theModel) {
        List<Banner> bannerList = bannerService.findAll();
        theModel.addAttribute("bannerList", bannerList);
        return "adminPanel/banner/th_bannerList";
    }

    @GetMapping("/banner/showForm")
    public String showFormForAddBanner(Model theModel) {
        Banner banner = new Banner();
        theModel.addAttribute("banner", banner);
        return "adminPanel/banner/th_banner-form";
    }

    @PostMapping("/banner/saveBanner")
    public String saveBanner(@ModelAttribute("banner") Banner banner, @RequestParam("file") MultipartFile file) {
        bannerService.saveOrUpdate(banner);
        String bannerUrl = bannerService.saveBannerImage(file, banner.getBannerId());
        banner.setUrl("images/myBannerFolder/"+bannerUrl);
        //todo i use saveOrUpdate again because i need update url . (the first way got circular bean exception) i must check it later:
        bannerService.saveOrUpdate(banner);
        return "redirect:/banner/banner/list";
    }

    @GetMapping("/banner/updateForm")
    public String showFormForUpdateBanner(@RequestParam("bannerId") Long bannerId, Model theModel) {
        Banner banner = bannerService.findById(bannerId);
        theModel.addAttribute("banner", banner);
        return "adminPanel/banner/th_banner-form";
    }

    @GetMapping("/banner/delete")
    public String deleteBanner(@RequestParam(value ="bannerId") Long bannerId) {
        bannerService.deleteById(bannerId);
        return "redirect:/banner/banner/list";
    }

}
