package com.magotecnologia.Elements.Devices;

import com.magotecnologia.Elements.CommDevice;

import java.util.Random;

public class Repeater extends CommDevice{



    public Repeater() {
        Random randomizer = new Random();
        int randomIdentifier=randomizer.nextInt(1000000);
        this.id= "Repeater"+String.format ("%06d", randomIdentifier);
        this.delay=3;
    }
}
