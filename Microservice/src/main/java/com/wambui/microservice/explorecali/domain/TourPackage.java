package com.wambui.microservice.explorecali.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class TourPackage {
    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage(){
    }

    public TourPackage(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
