package com.adp.parking;

import com.adp.parking.constants.TypeParking;
import com.adp.parking.model.ParkingPlace;
import com.adp.parking.service.ServiceParking;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class ParkingPlaceTest {

    private ServiceParking service;
    HashMap<ParkingPlace,Boolean> parking;

    @Before
    public void  init(){

        service = new ServiceParking();
        parking = new HashMap<ParkingPlace, Boolean>();

        //Parking space is available if the value es true.
        parking.put(new ParkingPlace(TypeParking.HANDICAP_TYPE,1,3,5),new Boolean(true));
        parking.put(new ParkingPlace(TypeParking.HANDICAP_TYPE,3,3,5),new Boolean(true));
        parking.put(new ParkingPlace(TypeParking.STANDARD_TYPE,3,3,5),new Boolean(true));


        //Parking space is NOT AVAILABLE if the value es false, this is Occupied
        parking.put(new ParkingPlace(TypeParking.STANDARD_TYPE,2,1.5,1),new Boolean(false));
        parking.put(new ParkingPlace(TypeParking.HANDICAP_TYPE,4,1,2),new Boolean(false));
        parking.put(new ParkingPlace(TypeParking.HANDICAP_TYPE,5,1,3),new Boolean(false));
        parking.put(new ParkingPlace(TypeParking.HANDICAP_TYPE,6,1,2),new Boolean(false));
    }


    @Test
    public void slotsAvailable(){
        List<ParkingPlace> list=service.getAvailableSpace(parking);
        for (ParkingPlace parkingPlace: list
        ) {
            System.out.println("The  "+parkingPlace+ " type is available");
        }
    }


    @Test
    public void potentialRevenue(){
        double revenue=service.potentialRevenue(parking);
        System.out.println("Potential revenue: $ "+revenue);
    }
}
