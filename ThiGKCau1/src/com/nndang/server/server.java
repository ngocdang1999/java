/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nndang.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;
import javax.sound.midi.Receiver;

/**
 *
 * @author NguyenNgocDang
 */
public class server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket serverSocket = new DatagramSocket(8888);
        byte[] recieverData = new byte[1024];
        System.out.println("Waiting..........");
        while (true) {
            DatagramPacket recieverPacket = new DatagramPacket (recieverData, recieverData.length);
            serverSocket.receive(recieverPacket);//nhận dử liệu
            String sentence = new String(recieverPacket.getData());
            Random rd = new Random();
            int Number = Integer.parseInt(sentence.trim());
            System.out.println("Nhập vào từ client:" + Number);
            int random1 = rd.nextInt(Number) +1;
            System.out.println("Số thứ nhất:" + random1);
            int random2 = rd.nextInt(Number) +1;
            System.out.println("Số thứ hai:" + random2);
            int tich2so = random1*random2;
            System.out.println("Tích: " + tich2so);
            byte[] sentData = new byte[1024];
            sentData = String.valueOf(tich2so).getBytes();

            DatagramPacket sentPacket = new DatagramPacket(sentData, sentData.length, recieverPacket.getAddress(), recieverPacket.getPort());
            serverSocket.send(sentPacket);
    }
    }
}
