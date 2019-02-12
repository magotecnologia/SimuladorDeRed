package com.magotecnologia.Elements.Devices;

import com.magotecnologia.Elements.CommDevice;

import java.util.Random;

public class Router extends CommDevice {


    public Router() {
        Random randomizer = new Random();
        int randomIdentifier=randomizer.nextInt(1000000);
        this.id= "Router"+String.format ("%06d", randomIdentifier);
        this.delay=1;
    }


}
