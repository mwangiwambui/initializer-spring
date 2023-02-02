package com.wambui.microservice.explorecali.repo;

import com.wambui.microservice.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {
}
