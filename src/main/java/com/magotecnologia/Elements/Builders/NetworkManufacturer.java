package com.magotecnologia.Elements.Builders;

import com.magotecnologia.Elements.Network;

public class NetworkManufacturer {


    public Network Construct(NetworkBuilderable predeterminatedNetwork){
        predeterminatedNetwork.createAllChannels();
        predeterminatedNetwork.createAllComputers();
        predeterminatedNetwork.createAllDevices();
        predeterminatedNetwork.connectComputers();
        predeterminatedNetwork.connectDevices();
        return predeterminatedNetwork.GetNetwork();
    }
}
