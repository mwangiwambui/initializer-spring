package com.wambui.microservice.explorecali.repo;

import com.wambui.microservice.explorecali.domain.Difficulty;
import com.wambui.microservice.explorecali.domain.Region;
import com.wambui.microservice.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    Page<Tour> findByTourPackageCode(@Param("code")String code, Pageable pageable);

    Optional<Tour> findByTitle(String title);

    List<Tour> findByPrice(Integer price);

    Collection<Tour> findByDifficulty(Difficulty difficulty);

    List<Tour> findByRegion(Region region);
}
