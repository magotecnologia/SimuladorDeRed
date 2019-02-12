package com.magotecnologia.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class CommDevice {
    //Id del dispositivo
    protected String id;
    //Lista de canales conectados
    private List<Channel> commChannel;
    //Mensajes que han pasado por este dispostitivo
    private Set<String> messages;
    protected int delay;

    public List<Channel> getCommChannel() {
        return commChannel;
    }

    public void setCommChannel(List<Channel> commChannel) {
        this.commChannel = commChannel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método que añade un canal al dispositivo, "conectandolo" a ese canal
     * @param channelToAdd canal que se añadira a la lista
     */
    public void addCommChannel(Channel channelToAdd) {
        if (commChannel == null) {
            commChannel = new ArrayList<>();
        }
        commChannel.add(channelToAdd);
    }

    /**
     * Metodo que recibe un mensaje
     * @param incomingMessage Mensaje recibido
     * @see Message
     * @param senderChannel  Canal que envìa el mensale
     * @see Channel
     */
    public void receiveMessage(Message incomingMessage, Channel senderChannel) {
        if(isReallyANewMessage(incomingMessage)) {
            try {
                Thread.sleep(delay * 1000);
                for (Channel canal : commChannel) {
                    if (senderChannel.getId() != canal.getId()) {
                        sendMessage(incomingMessage, canal);
                    }
                }
                if (messages == null){
                    messages= new HashSet<>();
                }
                messages.add(incomingMessage.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo que le envia un mensaje a un canal en donde se esta conectado
     * @param outcomingMessage Mensaje que será enviado
     * @see Message
     * @param channelToSent Canal al que serà enviado
     */
    private void sendMessage(Message outcomingMessage, Channel channelToSent){
        outcomingMessage.setTotalTime(outcomingMessage.getTotalTime()+delay);
        outcomingMessage.addInterDevice(this.id);
        channelToSent.receiveMessageFromDevice(outcomingMessage, this);
    }

    /**
     * Metodo que revisa si el mensaje ya paso por este dispositivo
     * @param messageToCheck Mensaje que se revisarà
     * @return devuelve true si el mensaje es nuevo y false si el mensaje ya ha pasado por el dispositivo
     */
    private boolean isReallyANewMessage(Message messageToCheck){
       if(messages != null) {
           return !messages.contains(messageToCheck.getId());
       }
           else{
                return true;
       }


    }
}