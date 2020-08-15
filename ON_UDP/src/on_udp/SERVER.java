/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author NguyenNgocDang
 */
public class SERVER {
    public static void main(String[] args) throws IOException, SocketException{
        DatagramSocket serverSocket = new DatagramSocket(8888);
        byte[] receiverData = new byte[1028];
        System.out.println("Waiting.....");
        while (true) {            
            DatagramPacket serverPacket = new DatagramPacket(receiverData, receiverData.length);
            serverSocket.receive(serverPacket);
            System.out.println("Connection");
            String sentence = new String(serverPacket.getData());
            int number = Integer.parseInt(sentence.trim());
            int giaithua = 1; 
            if (number == 0 || number==1){
                giaithua = 1;
            }else{
                for (int i = 1; i <= number; i++) {
                    giaithua = giaithua*i;
                }
            }
            
            byte[] sentData = new byte[1024];
            sentData = String.valueOf(giaithua).getBytes();
            DatagramPacket sentPacket = new DatagramPacket(sentData, sentData.length, serverPacket.getAddress(), serverPacket.getPort());
            serverSocket.send(sentPacket);
            System.out.println("Done....");
        }
    }
}
