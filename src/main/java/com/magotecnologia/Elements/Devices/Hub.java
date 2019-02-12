package com.magotecnologia.Elements.Devices;

import com.magotecnologia.Elements.CommDevice;

import java.util.Random;

public class Hub extends CommDevice {



    public Hub() {
        Random randomizer = new Random();
        int randomIdentifier=randomizer.nextInt(1000000);
        this.id= "Hub"+String.format ("%06d", randomIdentifier);
        this.delay=2;
    }
}
