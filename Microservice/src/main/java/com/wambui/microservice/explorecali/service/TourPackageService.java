package com.wambui.microservice.explorecali.service;

import com.wambui.microservice.explorecali.domain.TourPackage;
import com.wambui.microservice.explorecali.repo.TourPackageRepository;
import com.wambui.microservice.explorecali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository){
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name){

        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    public Iterable<TourPackage> lookup() { return tourPackageRepository.findAll(); }

    public long total() {
        return tourPackageRepository.count();
    }
}
