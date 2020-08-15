/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

/**
 *
 * @author NguyenNgocDang
 */
public class CLIENT {
    public static void main(String[] args) throws IOException{
        BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhập vào 1 số: ");
        String sentence = inFormUser.readLine();
        
        
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sentData = new byte[1024];
        sentData = sentence.getBytes();
        InetAddress add = InetAddress.getByName("localhost");
        
        DatagramPacket sendPacket = new DatagramPacket(sentData, sentData.length, add, 8888);
        clientSocket.send(sendPacket);
        
        byte[] recieverData = new byte[1024];
        DatagramPacket recieverPacket = new DatagramPacket(recieverData, recieverData.length);
        clientSocket.receive(recieverPacket);
        
        String a = new String(recieverPacket.getData());
        
        System.out.println("Kết qua: "+ a.trim());
        
        clientSocket.close();
    }
}
