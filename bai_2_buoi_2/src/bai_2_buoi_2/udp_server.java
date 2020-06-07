/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2_buoi_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author NguyenNgocDang
 */
public class udp_server {
    public static void main(String[] args) throws SocketException, IOException {
        String newServer;
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket serverSocket = new DatagramSocket(9999);
        System.out.println("Waiting.......");
    while(true){
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];        
        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length); // gói dữ liệu để nhận
        serverSocket.receive(receivePacket);    
        String sentence = new String(receivePacket.getData());
        System.out.println("Nhận từ client:"+sentence);
        System.out.print("Server nhập vào:");
        newServer = inFromServer.readLine();               
        sendData = newServer.getBytes();
        int port = receivePacket.getPort();
        InetAddress ipAddress = receivePacket.getAddress();
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,ipAddress,port);
        serverSocket.send(sendPacket);             
        }
    }
}