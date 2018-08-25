package com.magotecnologia.Elements.Builders;

import com.magotecnologia.Elements.Channel;
import com.magotecnologia.Elements.CommDevice;
import com.magotecnologia.Elements.Computer;
import com.magotecnologia.Elements.Devices.Router;
import com.magotecnologia.Elements.Devices.Switch;
import com.magotecnologia.Elements.Network;

import java.util.ArrayList;
import java.util.List;

public class NetworkBuilder3 implements  NetworkBuilderable {
    Network mypredeterminatedNetwork;
    public void createAllChannels() {
        //crear 3 canales
        Channel channel1= new Channel();
        Channel channel2= new Channel();
        Channel channel3= new Channel();
        List<Channel> channelList= new ArrayList<>();
        channelList.add(channel1);
        channelList.add(channel2);
        channelList.add(channel3);
        mypredeterminatedNetwork.setChannelList(channelList);
    }

    public void createAllComputers() {
        //Crear 3 computadores
        Computer pc1= new Computer("175.0.0.90");
        Computer pc2= new Computer("157.0.0.91");
        Computer pc3= new Computer("157.0.0.92");
        List<Computer> computers=  new ArrayList<>();
        computers.add(pc1);
        computers.add(pc2);
        computers.add(pc3);
        mypredeterminatedNetwork.setComputerList(computers);
    }

    public void createAllDevices() {
        CommDevice aSwitch= new Switch();
        CommDevice router= new Router();
        List<CommDevice> devices= new ArrayList<>();
        devices.add(aSwitch);
        devices.add(router);
        mypredeterminatedNetwork.setCommDeviceList(devices);
    }

    public void connectComputers(){
        //Conecto el primer pc al primer canal
        mypredeterminatedNetwork.connectComputer(mypredeterminatedNetwork.getComputerList().get(0),mypredeterminatedNetwork.getChannelList().get(0));
        //Conecto el segundo pc al tercer canal
        mypredeterminatedNetwork.connectComputer(mypredeterminatedNetwork.getComputerList().get(1),mypredeterminatedNetwork.getChannelList().get(2));
        //Conecto el tercer pc al tercer canal
        mypredeterminatedNetwork.connectComputer(mypredeterminatedNetwork.getComputerList().get(2),mypredeterminatedNetwork.getChannelList().get(2));
    }

    public void connectDevices() {
        //Conecto el primer dispositivo al primer canal
        mypredeterminatedNetwork.connectDevice(mypredeterminatedNetwork.getCommDeviceList().get(0),mypredeterminatedNetwork.getChannelList().get(0));
        //Conecto el primer dispositivo al segundo canal
        mypredeterminatedNetwork.connectDevice(mypredeterminatedNetwork.getCommDeviceList().get(0),mypredeterminatedNetwork.getChannelList().get(1));
        //Conecto el segundo dispositivo al segundo canal
        mypredeterminatedNetwork.connectDevice(mypredeterminatedNetwork.getCommDeviceList().get(1),mypredeterminatedNetwork.getChannelList().get(1));
        //Conecto el segundo dispositivo al tercer canal
        mypredeterminatedNetwork.connectDevice(mypredeterminatedNetwork.getCommDeviceList().get(1),mypredeterminatedNetwork.getChannelList().get(2));
    }

    public Network GetNetwork() {
        return mypredeterminatedNetwork;
    }

    public NetworkBuilder3() {
        this.mypredeterminatedNetwork=new Network();
    }
}
