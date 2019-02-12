package com.magotecnologia.Elements;

import java.util.Random;

public class Computer{
    //Ip del computador que envía
    private String Ip;
    //Canal de comunicación al que esta conectado
    private Channel commChannel;

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public Channel getCommChannel() {
        return commChannel;
    }

    public void setCommChannel(Channel commChannel) {
        this.commChannel = commChannel;
    }

    /**
     * Contructor que se le pasa la IP
     * @param ip IP del computador a construir
     */
    public Computer(String ip) {
        Ip = ip;
    }

    /**
     * Constructor que genera una IP al azar
     */
    public Computer() {
        Ip=getRandomIP();
    }

    /**
     * Método privado para la generación de una IP
     * @return String de la forma "XXX.XXX.XXX.XXX" donde XXX son numeros al azar entre 0 y 255
     */
    private String getRandomIP(){
        String randomIp;
        StringBuilder builderIp= new StringBuilder();
        for(int i=0;i<4;i++){
            Random randomSegment = new Random();
            int ipSegment= randomSegment.nextInt(256);
            builderIp.append(ipSegment);
            builderIp.append(".");
        }
        builderIp.setLength(builderIp.length() - 1);
        return builderIp.toString();
    }

    /**
     * Metodo que le envia un mensaje al canal en donde se esta conectado
     * @param outcomingMessage Mensaje que será enviado
     * @see Message
     */
    public void sendMessage(Message outcomingMessage){
        if(commChannel !=null){
        commChannel.receiveMessageFromPC(outcomingMessage, this);
        }
    }

    /**
     * Metodo que recibe un mensaje
     * @param incomingMessage Mensaje recibido
     * @see Message
     */
    public void receiveMessage(Message incomingMessage) {
        if(incomingMessage.getReceiver().equals("*")|| incomingMessage.getReceiver().equals(this.Ip)) {
            System.out.println("Mensaje recibido por computador con IP:"+this.Ip );
            System.out.println("El mensaje lo envió el computador con IP"+ incomingMessage.getSender());
            if(incomingMessage.getInterDevices()!= null){
                StringBuilder messageBuilder= new StringBuilder();
                messageBuilder.append("El mensaje pasó por los siguientes dispositivos:");
                for (String interDevice: incomingMessage.getInterDevices()) {
                    messageBuilder.append(interDevice);
                    messageBuilder.append(",");
                }
                messageBuilder.setLength(messageBuilder.length() - 1);
                messageBuilder.append(".");
                System.out.println(messageBuilder.toString());
            }
            System.out.println("Contenido: "+ incomingMessage.getBody()+ "\n");
        }
    }
}
