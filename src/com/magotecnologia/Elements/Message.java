package com.magotecnologia.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Message {
    private String id;
    private int totalTime;
    //Cuerpo del mensaje
    private String body;
    //Id del dispositivo que envío el mensaje
    private String sender;
    //Id del dispositivo objetivo
    private String receiver;
    //Dispositivos por los que pasa
    private Set<String> interDevices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Set<String> getInterDevices() {
        return interDevices;
    }

    public void setInterDevices(Set<String> interDevices) {
        this.interDevices = interDevices;
    }

    /**
     * Método privado para la generación de un numero al azar de 0 -999.999
     * @return Entero entre 0-999.999
     */
    private int getRandomId(){
        Random randomizer = new Random();
        return randomizer.nextInt(1000000);
    }

    /**
     * Constructor del mensaje con los diferentes valores
     * @param body contenido del mensaje
     * @param sender string que contiene la IP del computador que envía este mensaje
     * @param receiver string que contiene el destino del mensaje
     */
    public Message(String body, String sender, String receiver) {
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
        this.id=String.format ("%06d",getRandomId());
    }

    /**
     * Metodo que añade el Id de un dispositico por el que pasa el mensaje
     * @param deviceIdToAdd Id del dispositivo que va a ser agregado a la lista de los dispositivos de paso
     */
    public void addInterDevice(String deviceIdToAdd){
        if(interDevices== null){
            interDevices= new HashSet<>();
        }
        interDevices.add(deviceIdToAdd);
    }

}
