package com.wambui.microservice.explorecali.repo;

import com.wambui.microservice.explorecali.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

public interface TourPackageRepository extends CrudRepository <TourPackage, String> {
}
