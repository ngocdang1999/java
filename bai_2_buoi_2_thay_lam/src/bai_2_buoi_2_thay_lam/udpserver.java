/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2_buoi_2_thay_lam;

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
public class udpserver {
    public static void main(String[] args) throws SocketException, IOException {
        
    
//chi cần sac dinh ip/port thì sẽ duoc thuc hien viec nhan va gui
    //khong phai là client server
    //khai bao cong cu nhap tu ban phim dê chat
    
    BufferedReader inUser;
    //
    inUser = new BufferedReader(new InputStreamReader(System.in));

//cong cu để nhan và gửi du liệu qua sender
    
    DatagramSocket receiverSocket;//khai bao
    //goi du liệu
    DatagramPacket receiverPacket, senPacket;
    //Tin nhan nhan va gui 
    String receiverStr, senStr;
    
    //Dia chi cua gui va port
    
    InetAddress ipAddress;
    
    int port;
    
    //khoi tao goi nhan
    byte[] receiverData = new byte[1024];
    receiverPacket = new DatagramPacket(receiverData,receiverData.length);
    //thuc hien viec nhan du liệu
    //su dung cong cu de nhan
    
    receiverSocket = new DatagramSocket(7777);//khoi tao công cu nhận
        while (true) {            
            
    //thuc hien nhan
    
    receiverSocket.receive(receiverPacket);
    //tach du lieu ra
    
    receiverStr = new String(receiverPacket.getData());
    
    System.out.println(receiverStr);
    //chat tro lai
    
    senStr=inUser.readLine();
    //gui tin nhan cho nguoij gui
    //khoi tao goi gui
    byte[] sentdata = new byte[1024];
    sentdata = senStr.getBytes();
    senPacket =new DatagramPacket(sentdata,sentdata.length,receiverPacket.getAddress(),receiverPacket.getPort());
    //thuchienviecgui
    receiverSocket.send(senPacket);
    }
    }
}