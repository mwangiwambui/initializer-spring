package com.wambui.microservice.explorecali.repo;

import com.wambui.microservice.explorecali.domain.Difficulty;
import com.wambui.microservice.explorecali.domain.Region;
import com.wambui.microservice.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(String code);

    Optional<Tour> findByTitle(String title);

    List<Tour> findByPrice(Integer price);

    Collection<Tour> findByDifficulty(Difficulty difficulty);

    List<Tour> findByRegion(Region region);
}
