package com.magotecnologia.Elements.Builders;

import com.magotecnologia.Elements.Channel;
import com.magotecnologia.Elements.CommDevice;
import com.magotecnologia.Elements.Computer;
import com.magotecnologia.Elements.Devices.Bridge;
import com.magotecnologia.Elements.Network;

import java.util.ArrayList;
import java.util.List;

public class NetworkBuilder1 implements NetworkBuilderable {

    Network mypredeterminatedNetwork;

    public void createAllChannels(){
        //crear 2 canales
        Channel channel1= new Channel();
        Channel channel2= new Channel();
        List<Channel> channelList= new ArrayList<>();
        channelList.add(channel1);
        channelList.add(channel2);
        mypredeterminatedNetwork.setChannelList(channelList);
    }
    public void createAllComputers(){
        //Crear 3 computadores
        Computer pc1= new Computer("175.0.0.90");
        Computer pc2= new Computer("175.0.0.91");
        Computer pc3= new Computer("175.0.0.92");
        List<Computer> computers=  new ArrayList<>();
        computers.add(pc1);
        computers.add(pc2);
        computers.add(pc3);
        mypredeterminatedNetwork.setComputerList(computers);
    }
    public void createAllDevices(){
        CommDevice bridge= new Bridge();
        List<CommDevice> devices= new ArrayList<>();
        devices.add(bridge);
        mypredeterminatedNetwork.setCommDeviceList(devices);
    }
    public void connectComputers(){
        //Conecto el primer pc al primer canal
        mypredeterminatedNetwork.connectComputer(mypredeterminatedNetwork.getComputerList().get(0),mypredeterminatedNetwork.getChannelList().get(0));
        //Conecto el segundo pc al segundo canal
        mypredeterminatedNetwork.connectComputer(mypredeterminatedNetwork.getComputerList().get(1),mypredeterminatedNetwork.getChannelList().get(1));
        //Conecto el tercer pc al segundo canal
        mypredeterminatedNetwork.connectComputer(mypredeterminatedNetwork.getComputerList().get(2),mypredeterminatedNetwork.getChannelList().get(1));
    }
    public void connectDevices(){
        //Conecto el primer dispositivo al primer canal
        mypredeterminatedNetwork.connectDevice(mypredeterminatedNetwork.getCommDeviceList().get(0),mypredeterminatedNetwork.getChannelList().get(0));
        //Conecto el primer dispositivo al segundo canal
        mypredeterminatedNetwork.connectDevice(mypredeterminatedNetwork.getCommDeviceList().get(0),mypredeterminatedNetwork.getChannelList().get(1));
    }
    public Network GetNetwork() {
        return mypredeterminatedNetwork;
    }

    public NetworkBuilder1(Network mypredeterminatedNetwork) {
        this.mypredeterminatedNetwork = mypredeterminatedNetwork;
    }

    public NetworkBuilder1() {
        this.mypredeterminatedNetwork=new Network();
    }
}
