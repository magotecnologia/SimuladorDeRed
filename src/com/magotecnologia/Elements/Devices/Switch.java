package com.magotecnologia.Elements.Devices;

import com.magotecnologia.Elements.CommDevice;

import java.util.Random;

public class Switch extends CommDevice {

    public Switch() {
        Random randomizer = new Random();
        int randomIdentifier=randomizer.nextInt(1000000);
        this.id= "Switch"+String.format ("%06d", randomIdentifier);
        this.delay=4;
    }


}
