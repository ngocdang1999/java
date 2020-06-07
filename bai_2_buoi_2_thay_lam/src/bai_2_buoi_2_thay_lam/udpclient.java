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

/**
 *
 * @author NguyenNgocDang
 */
public class udpclient {
    public static void main(String[] args) throws IOException {
        //UPD thì sử dụng class java?
        
        //Nhập câu từ bàn phím
        BufferedReader inUser;
        
        //Công cụ để gửi/nhận gói tin datagramsocket
        
        DatagramSocket senderSocket = null;
        
        //datagrampacket đóng gói dữ liệu gửi đi, chứa dữ liệu nhận về
        
        DatagramPacket senPacket;//gui du lieu di
        
        //tai vì chúng ta đang chat
        
        DatagramPacket receiverPacket;//nhan du liệu về
        
        //khi ma cac ban gui du lieu và nhan du lieu thì gui chuổi 
        
        String sentence;
        String receiversentence;
        //khoi tao ip
        
        InetAddress ipAddress;
        
        
        //Muon su dung thi phai khởi tao
        while (true) {            
            
        inUser = new BufferedReader(new InputStreamReader(System.in));//khoi tao cong cu nhap
        System.out.println("Nhập vào thông tin để gui đi: ");
        sentence = inUser.readLine();
        
        //co du lieu r dong goi du lieu 
        byte[] buffSend = new byte[1024];
        buffSend = sentence.getBytes();
        
        //lay dia chi ip  cua receiver
        
        ipAddress = InetAddress.getByName("localhost");
        
        senPacket = new DatagramPacket(buffSend,buffSend.length , ipAddress, 7777);//hoan thanh viec dong goi cho viec gui đi
        
        // nhung ch khởi tạo công cụ
        
        senderSocket = new DatagramSocket();
        
        //thuc hien gui
        
        senderSocket.send(senPacket);
        
        //chat cho nen cần nhận về
        //khoi tao goi nhận
        byte[] buffReceiver = new byte[1024];
        receiverPacket = new DatagramPacket(buffReceiver, buffReceiver.length);
        //thuc hien viec nhan
        
        //su dung công cụ nhận
        senderSocket.receive(receiverPacket);
        
        //tách dữ liệu
        
        receiverPacket.getData();
        receiversentence = new String(receiverPacket.getData());
        
        //in ra mang hình 
        System.out.println(receiversentence);
        
    }
}
}