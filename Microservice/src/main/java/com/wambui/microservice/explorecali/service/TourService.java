package com.wambui.microservice.explorecali.service;

import com.wambui.microservice.explorecali.domain.Difficulty;
import com.wambui.microservice.explorecali.domain.Region;
import com.wambui.microservice.explorecali.domain.Tour;
import com.wambui.microservice.explorecali.domain.TourPackage;
import com.wambui.microservice.explorecali.repo.TourPackageRepository;
import com.wambui.microservice.explorecali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository){
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullet,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ){
        TourPackage tourPackage = null;

        return new Tour(title, description, blurb, price, duration, bullet, keywords, tourPackage, difficulty, region);
    }
}
