/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau_1_nguyen_ngoc_dang;

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
        System.out.print("Nhập vào 1 câu:");
        sentence = inFromUser.readLine();
        
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sentData = new byte[1024];
        sentData = sentence.getBytes();
        InetAddress Ipaddress = InetAddress.getByName("localhost");

        DatagramPacket sentPackacket = new DatagramPacket(sentData, sentData.length, Ipaddress, 8888);
        clientSocket.send(sentPackacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        
        String modifiedsentence = new String(receivePacket.getData());

        System.out.println("Kết quả:" + modifiedsentence.trim() + "\n");

        
        clientSocket.close();
    }
}
