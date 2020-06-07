/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nndang.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author NguyenNgocDang
 */
public class client {
    public static void main(String[] args) throws IOException {
        String sentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhập vào một số: ");
        sentence = inFromUser.readLine();
        
        
        //chuyen kieu du lieu : int -> String
            String s1 = String.valueOf(sentence);
            //chuyen kieu du lieu : String -> byte va dua vao mang byte da khai bao o tren
            
        
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sentData = new byte[1024];
        sentData = s1.getBytes();
        sentData = sentence.getBytes();
        InetAddress ipAdd = InetAddress.getByName("localhost");
        
        DatagramPacket sentPacket = new DatagramPacket(sentData, sentData.length, ipAdd, 8888);
        clientSocket.send(sentPacket);
        
        byte[] recieverData = new byte[1024];
        DatagramPacket recieverPacket = new DatagramPacket(recieverData, recieverData.length);
        clientSocket.receive(recieverPacket);
        
        String modifiedsentence = new String(recieverPacket.getData()).trim();
        System.out.println("Kết quả: " + modifiedsentence + "\n");
        clientSocket.close();
    }
}
