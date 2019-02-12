package com.magotecnologia.Elements.Builders;

import com.magotecnologia.Elements.Network;

public interface NetworkBuilderable {

    public void createAllChannels();
    public void createAllComputers();
    public void createAllDevices();
    public void connectComputers();
    public void connectDevices();
    public Network GetNetwork();
}
