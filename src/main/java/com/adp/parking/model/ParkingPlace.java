package com.adp.parking.model;

public class ParkingPlace {

    private String type;
    private int identificationNumber;
    private double rateByHour;
    private double timeParking;

    public ParkingPlace(String type,int identificationNumber, double timeParking){
       this.type=type;
       this.identificationNumber=identificationNumber;
       this.timeParking=timeParking;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public double getRateByHour() {

        double fixRate;
        if(this.timeParking<1){
            fixRate = 2;
        }else{
            fixRate = 2*this.timeParking;
        }
        return fixRate;
    }

    public void setRateByHour(double rateByHour) {
        this.rateByHour = rateByHour;
    }

    public double getTimeParking() {
        return timeParking;
    }

    public void setTimeParking(double timeParking) {
        this.timeParking = timeParking;
    }

    @Override
    public String toString() {
        return getType() + " with number: " + getIdentificationNumber();
    }
}
