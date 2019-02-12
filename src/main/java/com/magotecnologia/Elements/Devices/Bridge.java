package com.magotecnologia.Elements.Devices;

import com.magotecnologia.Elements.CommDevice;

import java.util.Random;

public class Bridge extends CommDevice {

    public Bridge() {
        Random randomizer = new Random();
        int randomIdentifier=randomizer.nextInt(1000000);
        this.id= "Bridge"+String.format ("%06d", randomIdentifier);
        this.delay=5;
    }
}
