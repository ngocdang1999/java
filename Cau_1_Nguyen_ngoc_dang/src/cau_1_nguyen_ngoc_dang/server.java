/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau_1_nguyen_ngoc_dang;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author NguyenNgocDang
 */
public class server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket serverSocker = new DatagramSocket(8888);
        byte[] recieverData = new byte[1028];
        System.out.println("Waiting......");
        while (true) {            
            DatagramPacket recieverPacket = new DatagramPacket(recieverData, recieverData.length);
            serverSocker.receive(recieverPacket);
            System.out.println("Kết nối thành công.");
            String sentence = new String(recieverPacket.getData());
            String recieversentence = sentence.toUpperCase();
            
            byte[] sentData = new byte[1024];
            sentData = recieversentence.getBytes();
            DatagramPacket sentPacket = new DatagramPacket(sentData, sentData.length,recieverPacket.getAddress(),recieverPacket.getPort());
            serverSocker.send(sentPacket);
            System.out.println("Done!!!");
        }
    }
}
