package com.magotecnologia.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Channel {
    //Id del canal
    private int id;
    //Lista de computadores conectados
    private List<Computer> connectedComputers;
    //Lista de dispositivos conectados
    private List<CommDevice> connectedDevices;

    /**
     * Constructor que generà un Id al azar para el canal
     */
    public Channel() {
        Random randomId = new Random();
        this.id= randomId.nextInt(1024);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Computer> getConnectedComputers() {
        return connectedComputers;
    }

    public void setConnectedComputers(List<Computer> connectedComputers) {
        this.connectedComputers = connectedComputers;
    }

    public List<CommDevice> getConnectedDevices() {
        return connectedDevices;
    }

    public void setConnectedDevices(List<CommDevice> connectedDevices) {
        this.connectedDevices = connectedDevices;
    }

    public void addComputer(Computer computerToAdd){
        if(connectedComputers== null){
            connectedComputers= new ArrayList<>();
        }
        connectedComputers.add(computerToAdd);
    }

    public void addDevice(CommDevice deviceToAdd){
        if(connectedDevices== null){
            connectedDevices=new ArrayList<>();
        }
        connectedDevices.add(deviceToAdd);
    }

    /**
     * Metodo que recibe un mensaje desde una pc
     * @param incomingMessage Mensaje recibido
     * @see Message
     * @param senderComputer  Computador que envìa el mensale
     * @see Channel
     */
    public void receiveMessageFromPC(Message incomingMessage, Computer senderComputer ) {
        if(connectedComputers !=null) {
            for (Computer connectedComputer:connectedComputers ) {
                if(!senderComputer.getIp().equals(connectedComputer.getIp())) {
                    sendMessageToPc(incomingMessage, connectedComputer);
                }
            }
        }
        if(connectedDevices !=null){
            for (CommDevice device:connectedDevices){
                sendMessageToDevice(incomingMessage,device);
            }
        }
    }

    /**
     * Metodo que recibe un mensaje desde una pc
     * @param incomingMessage Mensaje recibido
     * @see Message
     * @param senderDevice  Dispositivo que envìa el mensale
     * @see Channel
     */
    public void receiveMessageFromDevice(Message incomingMessage, CommDevice senderDevice ) {
        if(connectedComputers !=null) {
            for (Computer connectedComputer : connectedComputers) {
                sendMessageToPc(incomingMessage, connectedComputer);
            }
        }
        if(connectedDevices !=null){
            for (CommDevice device:connectedDevices){
                if(!senderDevice.getId().equals(device.getId())) {
                    sendMessageToDevice(incomingMessage,device);
                }
            }
        }
    }

    /**
     * Metodo que le envia un mensaje a un computador
     * @param outcomingMessage Mensaje que será enviado
     * @see Message
     * @param computerToSent Computador que recibira el mensaje
     */
    private void sendMessageToPc(Message outcomingMessage, Computer computerToSent){
        computerToSent.receiveMessage(outcomingMessage);
    }

    /**
     * Metodo que le envia un mensaje a un computador
     * @param outcomingMessage Mensaje que será enviado
     * @see Message
     * @param deviceToSent Dispositivo que recibira el mensaje
     */
    private void sendMessageToDevice(Message outcomingMessage, CommDevice deviceToSent){
        deviceToSent.receiveMessage(outcomingMessage, this);
    }
}
