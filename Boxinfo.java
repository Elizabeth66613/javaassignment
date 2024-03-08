package com.example.lab34;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//class for constructor, getters and setter for table
public class Boxinfo extends HelloApplication {

    //initialize variables
    private final IntegerProperty rank;
    private final StringProperty country;
    private final IntegerProperty gold;
    private final IntegerProperty silver;
    private final IntegerProperty bronze;
    private final IntegerProperty medals;

    //constructor
    public Boxinfo(Integer rank, String country, Integer gold, Integer silver, Integer bronze, Integer medals) {
        this.rank = new SimpleIntegerProperty(rank);
        this.country = new SimpleStringProperty(country);
        this.gold = new SimpleIntegerProperty(gold);
        this.silver = new SimpleIntegerProperty(silver);
        this.bronze = new SimpleIntegerProperty(bronze);
        this.medals = new SimpleIntegerProperty(medals);
    }

    //setters and getters
    public Integer getRank(){
        return rank.get();
    }
    public String getCountry(){

        return country.get();
    }
    public Integer getGold(){
        return gold.get();
    }
    public Integer getSilver(){

        return silver.get();
    }
    public Integer getBronze(){

        return bronze.get();
    }
    public Integer getMedals(){

        return medals.get();
    }
    public void setRank(Integer value) {

        rank.set(value);
    }
    public void setCountry(String value) {

        country.set(value);
    }
    public void setGold(Integer value) {
        gold.set(value);
    }
    public void setSilver(Integer value) {
        silver.set(value);
    }
    public void setBronze(Integer value) {

        bronze.set(value);
    }
    public void setMedals(Integer value) {

        medals.set(value);
    }
    public IntegerProperty rankProperty() {
        return rank;
    }

    public StringProperty countryProperty() {
        return country;
    }
    public IntegerProperty goldProperty() {
        return gold;
    }
    public IntegerProperty silverProperty() {
        return silver;
    }
    public IntegerProperty bronzeProperty() {
        return bronze;
    }

    public IntegerProperty medalsProperty() {
        return medals;
    }
}
