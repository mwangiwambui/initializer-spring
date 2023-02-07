package com.wambui.microservice.explorecali.repo;

import com.wambui.microservice.explorecali.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository <TourPackage, String> {
    Optional<TourPackage> findByName(String name);
}
