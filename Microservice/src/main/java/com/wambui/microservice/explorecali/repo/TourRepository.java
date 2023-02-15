package com.wambui.microservice.explorecali.repo;

import com.wambui.microservice.explorecali.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface TourRepository extends PagingAndSortingRepository<Tour, String> {
    Page<Tour> findByTourPackageCode(@Param("code")String code, Pageable pageable);

    @Query(value = "{'tourPackageCode' : ?0 }", fields = "{'id':1, 'title': 1, 'tourPackageCode': 1, 'tourPackageName':1}")
    Page<Tour> findSummaryByTourPackageCode(@Param("code")String code, Pageable pageable);
    Optional<Tour> findByTitle(String title);

    @Override
    @RestResource(exported = false)
    Iterable<Tour> findAll(Sort sort);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void deleteById(String string);

    @Override
    @RestResource(exported = false)
    void delete(Tour entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends String> strings);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    List<Tour> findByPrice(Integer price);


}
