package com.magotecnologia.Elements;

import com.magotecnologia.Elements.Devices.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Network {
    //Lista de todos los computadores en la red
    private List<Computer> computerList;
    //Lista de todos los dispositivos en la red
    private List<CommDevice> commDeviceList;
    //Lista de todos los canales de la red
    private List<Channel> channelList;

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    public List<CommDevice> getCommDeviceList() {
        return commDeviceList;
    }

    public void setCommDeviceList(List<CommDevice> commDeviceList) {
        this.commDeviceList = commDeviceList;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }
    /**
    * Metodo para la creación de un computador  en la red
     **/
    public void createComputer(){
        System.out.println("Escriba la IP que se desea asignar \n");
        Scanner scannerIp= new Scanner(System.in);
        String entradaIp = scannerIp.next();
        Computer creatingComputer= new Computer(entradaIp);
        System.out.println("Creando computador \n");
        System.out.println("IP asignada:"+ creatingComputer.getIp() );
        System.out.println("Desea conectarlo a un canal de comunicaciòn? Y/N ");
        Scanner scanner= new Scanner(System.in);
        String entrada = scanner.next();
        switch (entrada){
            case "Y":
                Channel channelToConnect=selectChannel();
                if(channelToConnect!= null) {
                    connectComputer(creatingComputer,channelToConnect );
                }
                else {
                    System.out.println("ID de Canal no encontrado");
                }
                break;
            case "N":
                System.out.println("No se podrá comunicar sin asignarsele un canal de comunicación");
                break;
            default:
                System.out.println("Opción no reconocida \n");
                break;
        }
        if(computerList == null){
            computerList= new ArrayList<>();
        }
        computerList.add(creatingComputer);
        System.out.println("La red tiene "+computerList.size() + " computadores" );
    }

    /**
     * Metodo para la creación de un canal  en la red
     **/
    public void createChannel(){
        Channel creatingChannel= new Channel();
        System.out.println("Creando canal \n");
        System.out.println("ID asignada:"+ creatingChannel.getId() );
        System.out.println("Desea conectarle un computador? Y/N ");
        Scanner scanner= new Scanner(System.in);
        String entrada = scanner.next();
        switch (entrada){
            case "Y":
                if(computerList != null){
                    System.out.println("Computadores disponibles");
                    showComputers();
                    System.out.println("Seleccione el computador al cual desea conectar escribiendo su IP");
                    Scanner scanning = new Scanner(System.in);
                    String entradaComputer = scanning.next();
                    Computer selectedComputer = computerList.stream().filter(computer -> entradaComputer.equals(computer.getIp())).findAny().orElse(null);
                    if(selectedComputer!= null) {
                        connectComputer(selectedComputer,creatingChannel );
                    }
                    else {
                        System.out.println("IP de Computador no encontrado");
                    }
                }
                else {
                    System.out.println("No hay computadores disponibles para la conexion");
                }
                break;
            case "N":
                break;
            default:
                System.out.println("Opción no reconocida \n");
                break;
        }
        if(channelList == null){
            channelList= new ArrayList<>();
        }
        channelList.add(creatingChannel);
        System.out.println("La red tiene "+channelList.size() + " canales" );
    }

    /**
     * Metodo para la creación de un dispositivo en la red
     **/
    public void createDevice() {
        CommDevice creatingDevice= null;
        System.out.println("Seleccione el tipo de dispositivo \n");
        System.out.println("1.Router  \n");
        System.out.println("2.Hub  \n");
        System.out.println("3.Repeater \n");
        System.out.println("4.Switch \n");
        System.out.println("5.Bridge \n");
        Scanner scanner= new Scanner(System.in);
        String entrada = scanner.next();
        switch (entrada){
            case "1":
                creatingDevice= new Router();
                break;
            case "2":
                creatingDevice= new Hub();
                break;
            case "3":
                creatingDevice= new Repeater();
                break;
            case "4":
                creatingDevice= new Switch();
                break;
            case "5":
                creatingDevice= new Bridge();
                break;
            default:
                System.out.println("Opción no reconocida \n");
                break;
        }
        if(creatingDevice != null) {
            String salidaAsignacionDeCanal="";
            System.out.println("Creando dispositivo \n");
            System.out.println("Asignado el ID:" + creatingDevice.getId() + " \n");
            if(commDeviceList == null){
                commDeviceList= new ArrayList<>();
            }
            commDeviceList.add(creatingDevice);
            System.out.println("La red tiene "+commDeviceList.size() + " dispositivos" );
            while(!salidaAsignacionDeCanal.equals("N")){
            System.out.println("Desea conectarlo a un canal de comunicación? Y/N ");
            Scanner scannerConnect= new Scanner(System.in);
            String entradaCanalAprobacion = scannerConnect.next();
            switch (entradaCanalAprobacion){
                case "Y":
                    Channel channelToConnect=selectChannel();
                    if(channelToConnect!= null) {
                        connectDevice(creatingDevice,channelToConnect );
                        }
                        else {
                            System.out.println("ID de Canal no encontrado");
                        }
                    break;
                case "N":
                    System.out.println("No se podrá comunicar sin asignarsele un canal de comunicación");
                    break;
                default:
                    System.out.println("Opción no reconocida \n");
                    break;
            }

            salidaAsignacionDeCanal= entradaCanalAprobacion;
            }
        }
    }

    /**
     * Metodo para mostrar la lista de los computadores en la red
     **/
    public void showComputers(){
        System.out.println("Mostrando los computadores de la red \n");
        if(computerList!= null){
            for (Computer computer:computerList){
                System.out.println((computerList.indexOf(computer)+1) + ": Computador con IP: "+ computer.getIp() );
            }
        }
        else{
            System.out.println("No hay computadores para esta red ");
        }
    }

    /**
     * Metodo para mostrar la lista de los canales en la red
     **/
    public void showChannels(){
        System.out.println("Mostrando los canales de la red \n");
        if(channelList != null){
            for (Channel channel:channelList){
                System.out.println((channelList.indexOf(channel)+1) + ": Canal de comunicación con ID: "+ channel.getId());
            }
        }
        else {
            System.out.println("No hay canales de comunicaciòn para esta red ");
        }
    }

    /**
     * Metodo para mostrar la lista de los dispositivos en la red
     **/
    public void showDevices(){
        System.out.println("Mostrando los dispositivos de la red \n");
        if(commDeviceList != null){
            for (CommDevice device:commDeviceList){
                System.out.println((commDeviceList.indexOf(device)+1)  + " Dispositivo con ID: "+ device.getId());
            }
        }
        else {
            System.out.println("No hay canales de comunicación para esta red ");
        }
    }

    /**
     * Metodo para seleccionar un computador y  seleccionar un canal para conectar
     **/
    public void connectComputerToChannel(){
        if(computerList != null){
            System.out.println("Computadores disponibles");
            showComputers();
            System.out.println("Seleccione el computador el desea conectar escribiendo su IP");
            Scanner scanning = new Scanner(System.in);
            String entradaComputador = scanning.next();
            Computer computerToConnect = computerList.stream().filter(computer -> entradaComputador.equals(computer.getIp())).findAny().orElse(null);
            if(computerToConnect!= null) {
                Channel channelToConnect = selectChannel();
                if(channelToConnect!= null) {
                    connectComputer(computerToConnect,channelToConnect );
                }
                else {
                    System.out.println("ID de Canal no encontrado");
                }
            }
        }
        else {
            System.out.println("No hay computadores para la conexion");
        }
    }

    /**
     * Metodo para seleccionar un dispositivo y  seleccionar un canal para conectar
     **/
    public void connectDeviceToChannel(){
        if(commDeviceList != null){
            System.out.println("Dispositivos disponibles");
            showDevices();
            System.out.println("Seleccione el dispositivo el desea conectar escribiendo su ID");
            Scanner scanning = new Scanner(System.in);
            String entradaDispositivo = scanning.next();
            CommDevice deviceToConnect = commDeviceList.stream().filter(computer -> entradaDispositivo.equals(computer.getId())).findAny().orElse(null);
            if(deviceToConnect!= null) {
                Channel channelToConnect=selectChannel();
                if(channelToConnect!= null) {
                    connectDevice(deviceToConnect,channelToConnect );
                }
                else {
                    System.out.println("ID de Canal no encontrado");
                }
            }
        }
        else {
            System.out.println("No hay computadores para la conexion");
        }
    }

    /**
     * Metodo para conectar una computadora a un canal
     * @param computerToConnect Computadora que se va a conectar
     * @param channelToConnect Canal en el cual se conecta la computadora
     **/
    public void connectComputer(Computer computerToConnect,Channel channelToConnect){
        System.out.println("Conectando el computador de IP:"+computerToConnect.getIp() + " al canal de ID:" + channelToConnect.getId() );
        //Adiciona el canal de comunicacion al computador
        computerToConnect.setCommChannel(channelToConnect);
        //Adiciona el computador al canal
        channelToConnect.addComputer(computerToConnect);
    }

    /**
     * Metodo para conectar un dispositivo a un canal
     * @param deviceToConnect Dispositivo que se va a conectar
     * @param channelToConnect Canal en el cual se conecta la computadora
     **/
    public void connectDevice(CommDevice deviceToConnect, Channel channelToConnect){
        System.out.println("Conectando el dispositivo con ID:"+deviceToConnect.getId() + " al canal de ID:" + channelToConnect.getId() );
        //Adiciona el canal de comunicacion al computador
        deviceToConnect.addCommChannel(channelToConnect);
        //Adiciona el computador al canal
        channelToConnect.addDevice(deviceToConnect);
    }

    /**
     *Método en el cual un usuario ingresa los datos de un mensaje y realiza su envío
     **/
    public void sendMessage() {
        if (computerList != null) {
            System.out.println("Computadores disponibles en la red");
            showComputers();
            System.out.println("Seleccione el computador desde el cual quiere enviar el mensaje  escribiendo su IP");
            Scanner scanning = new Scanner(System.in);
            String entradaComputer = scanning.next();
            Computer selectedComputer = computerList.stream().filter(computer -> entradaComputer.equals(computer.getIp())).findAny().orElse(null);
            if (selectedComputer != null) {
                if(selectedComputer.getCommChannel() != null) {
                    System.out.println("Escriba la IP de destino");
                    Scanner scanningDestino = new Scanner(System.in);
                    String entradaDestino = scanningDestino.next();
                    System.out.println("Escriba el cuerpo del mensaje");
                    Scanner scanningCuerpo = new Scanner(System.in);
                    String entradaCuerpo = scanningCuerpo.next();
                    Message messageToSent= new Message(entradaCuerpo,selectedComputer.getIp(),entradaDestino);
                    System.out.println("Mensaje enviado por computador con IP "+selectedComputer.getIp());
                    System.out.println("Con destino al computador con IP "+entradaDestino);
                    System.out.println("Contenido del mensaje: "+entradaCuerpo+"\n");
                    selectedComputer.sendMessage(messageToSent);

                }else{
                    System.out.println("El computador elegido no esta conectado a ningun canal de red");
                }

                } else {
                System.out.println("IP de Computador no encontrado");
            }
        } else {
            System.out.println("No hay computadores disponibles para la conexion");
        }
    }

    /**
     * Método para la selección de un canal de la red
     * @return canal seleccionado, devuelve null si no se encontró el ID escrito o no existen canales en la red
     */
    private Channel selectChannel(){
        if(channelList != null){
            System.out.println("Canales de comunicación disponibles");
            showChannels();
            System.out.println("Seleccione el canal de comunicación al cual desea conectar escribiendo su ID");
            Scanner scanning = new Scanner(System.in);
            String entradaCanal = scanning.next();
            return channelList.stream().filter(channel -> Integer.parseInt(entradaCanal) == channel.getId()).findAny().orElse(null);
        }
        else {
            System.out.println("No hay canales disponibles para la conexion");
            return null;
        }
    }
}
