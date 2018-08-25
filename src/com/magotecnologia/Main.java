package com.magotecnologia;

import com.magotecnologia.Elements.Builders.NetworkBuilder3;
import com.magotecnologia.Elements.Network;
import com.magotecnologia.Elements.Builders.NetworkBuilder1;
import com.magotecnologia.Elements.Builders.NetworkBuilder2;
import com.magotecnologia.Elements.Builders.NetworkManufacturer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Network myNetwork= new Network();
        while(true) {
            System.out.println("Escriba que desea realizar \n");
            System.out.println("1. Crear nuevo computador \n");
            System.out.println("2. Crear nuevo dispositivo \n");
            System.out.println("3. Crear nuevo canal de comunicación \n");
            System.out.println("4. Mostrar computadores \n");
            System.out.println("5. Mostrar los dispositivo \n");
            System.out.println("6. Mostrar los canales de comunicación \n");
            System.out.println("7. Conectar Computador a Canal \n");
            System.out.println("8. Conectar Dispositivo a Canal \n");
            System.out.println("9. Enviar mensaje \n");
            System.out.println("10. Construir Red 1 \n");
            System.out.println("11. Construir Red 2 \n");
            System.out.println("12. Construir Red 3 \n");
            Scanner scanner= new Scanner(System.in);
            String entrada = scanner.next();
            switch (entrada){
                case "1":
                    myNetwork.createComputer();
                    break;
                case "2":
                    myNetwork.createDevice();
                    break;
                case "3":
                    myNetwork.createChannel();
                    break;
                case "4":
                    myNetwork.showComputers();
                    break;
                case "5":
                    myNetwork.showDevices();
                    break;
                case "6":
                    myNetwork.showChannels();
                    break;
                case "7":
                    myNetwork.connectComputerToChannel();
                    break;
                case "8":
                    myNetwork.connectDeviceToChannel();
                    break;
                case "9":
                    myNetwork.sendMessage();
                    break;
                case "10":
                    NetworkManufacturer manufacturer= new NetworkManufacturer();
                    myNetwork=manufacturer.Construct(new NetworkBuilder1());
                    break;
                case "11":
                    NetworkManufacturer manufacturer2= new NetworkManufacturer();
                    myNetwork=manufacturer2.Construct(new NetworkBuilder2());
                    break;
                case "12":
                    NetworkManufacturer manufacturer3= new NetworkManufacturer();
                    myNetwork=manufacturer3.Construct(new NetworkBuilder3());
                    break;
                default:
                    System.out.println("Opción no reconocida \n");
                    break;
            }
            try{
                Thread.sleep(4000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }


}
