package com.andrux.andrux.repository;


import com.andrux.andrux.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BannerRepository extends JpaRepository<Banner, Long> {
    List<Banner> findByStatusIs(Boolean status);
}
