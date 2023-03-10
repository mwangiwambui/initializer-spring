package com.wambui.microservice.explorecali.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Objects;

@Document
public class Tour {
    @Id
    private String id;

    @Indexed
    private String title;

    @Indexed
    private String tourPackageCode;


    private String tourPackageName;

    private Map<String, String> details;


    public Tour(String title, TourPackage tourPackage, Map<String, String> details) {
        this.title = title;
        this.tourPackageCode = tourPackage.getCode();
        this.tourPackageName = tourPackage.getName();
        this.details = details;
    }

    protected Tour(){}

    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getTourPackageCode() {
        return tourPackageCode;
    }


    public String getTourPackageName() {
        return tourPackageName;
    }


    public Map<String, String> getDetails() {
        return details;
    }


    @Override
    public String toString() {
        return "Tour{" +
                "id='" + id + '\'' +
                ", details=" + details +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return getId().equals(tour.getId()) && getTitle().equals(tour.getTitle()) && getTourPackageCode().equals(tour.getTourPackageCode()) && getTourPackageName().equals(tour.getTourPackageName()) && getDetails().equals(tour.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, details);
    }
}

