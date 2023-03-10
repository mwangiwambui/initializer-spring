package com.wambui.microservice.explorecali.service;

import com.wambui.microservice.explorecali.domain.Tour;
import com.wambui.microservice.explorecali.domain.TourPackage;
import com.wambui.microservice.explorecali.repo.TourPackageRepository;
import com.wambui.microservice.explorecali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository){
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String tourPackageName , Map<String, String> details){
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour Package does not exist" + tourPackageName));
        return tourRepository.save(new Tour(title, tourPackage, details));
    }

    public long total() { return tourRepository.count(); }
}
