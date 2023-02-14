package com.wambui.microservice.explorecali.repo;

import com.wambui.microservice.explorecali.domain.TourRating;
import com.wambui.microservice.explorecali.domain.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

    List<TourRating> findByPkTourId(Integer tourId);

    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
