package com.example.demo.Pizza;

public class DeliveryAddress {

    private String Street;
    private String city;
    private String country;
    private String zipCode;

    public DeliveryAddress(String street, String city, String country, String zipCode) {
        Street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
