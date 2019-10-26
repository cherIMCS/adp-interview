package com.adp.parking.service;

import com.adp.parking.model.ParkingPlace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceParking {
    /**
     *
     * @param parkingSpaces
     * @return parking spaces available
     */
    public List<ParkingPlace> getAvailableSpace(HashMap<ParkingPlace,Boolean> parkingSpaces){

        List<ParkingPlace> listAvailableSpaces = new ArrayList<ParkingPlace>();
        for (Map.Entry<ParkingPlace,Boolean> entry: parkingSpaces.entrySet()){
              if(entry.getValue()){ //is the space available?
                  listAvailableSpaces.add(entry.getKey());
              }
        }

        return listAvailableSpaces;
    }

    /**
     * Getting the potencial revenue for each parking space occupied.
     * @param parkingSpaces
     * @return potencial revenue
     */
    public double potentialRevenue(HashMap<ParkingPlace,Boolean> parkingSpaces){

        double revenue=0.0;
        List<ParkingPlace> listAvailableSpaces = new ArrayList<ParkingPlace>();
        for (Map.Entry<ParkingPlace,Boolean> entry: parkingSpaces.entrySet()){
            if(!(entry.getValue())){
                revenue=revenue+(entry.getKey().getRateByHour());
            }
        }

        return revenue;
    }
}
