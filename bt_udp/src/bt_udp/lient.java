/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

/**
 *
 * @author NguyenNgocDang
 */
public class lient {
    public static void main(String[] args) throws IOException {
        //Nhập dử liệu từ bàn phím
        String sentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhập vào 1 câu:");
        sentence = inFromUser.readLine();
        
        //Gửi dữ liệu qua người nhận
        
        DatagramSocket clientSocket = new DatagramSocket();
        
        //gói dữ liệu
        byte[] sentData = new byte[1024];
        sentData = sentence.getBytes();
        InetAddress Ipaddress = InetAddress.getByName("localhost");

        //Đây là gói dữ liệu để gửi đi qua người nhận
        DatagramPacket sentPackacket = new DatagramPacket(sentData, sentData.length, Ipaddress, 8888);
        //Thực hiện việc gửi gói dử liệu đã được đóng gói
        clientSocket.send(sentPackacket);
        //nhận dữ liệu
        
        //cần gói để nhận
        byte[] receiveData = new byte[1024];//mảng rỗng
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);//đổ dử liệu vào gói receivepacket
        
        //lấy chuỗi ra
        
        String modifiedsentence = new String(receivePacket.getData());
        
        //in ra màn hình
        System.out.println("Kết quả:" + modifiedsentence + "\n");
        
        //dong kết nồi
        
        clientSocket.close();
    }
}
