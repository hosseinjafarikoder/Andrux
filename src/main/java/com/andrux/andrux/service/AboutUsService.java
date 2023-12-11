package com.andrux.andrux.service;



import com.andrux.andrux.entity.AboutUs;

import java.util.List;

public interface AboutUsService {
    AboutUs saveOrUpdate(AboutUs aboutUs) ;

    void deleteById(Long id);

    AboutUs findById(Long id);

    List<AboutUs> findAll();

}
