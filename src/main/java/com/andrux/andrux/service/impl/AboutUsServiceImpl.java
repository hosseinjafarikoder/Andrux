package com.andrux.andrux.service.impl;


import com.andrux.andrux.entity.AboutUs;
import com.andrux.andrux.exceptions.GeneralException;
import com.andrux.andrux.repository.AboutUsRepository;
import com.andrux.andrux.service.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AboutUsServiceImpl implements AboutUsService {

    @Autowired
    private AboutUsRepository aboutUsRepository;


    @Override
    public AboutUs saveOrUpdate(AboutUs aboutUs) {
        if (aboutUs.getId()==null && findAll().size()!=0){
            throw new GeneralException("آبجکت (درباره ی ما) یکبار ساخته شده است . فقط مجاز به آپدیت می باشید");
        }
        return aboutUsRepository.save(aboutUs);
    }

    @Override
    public void deleteById(Long id) {
        aboutUsRepository.deleteById(id);
    }

    @Override
    public AboutUs findById(Long id) {
        return aboutUsRepository.findById(id).get();
    }

    @Override
    public List<AboutUs> findAll() {
        return aboutUsRepository.findAll();
    }
}

