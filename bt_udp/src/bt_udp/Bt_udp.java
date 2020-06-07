/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_udp;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Receiver;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import javax.print.DocFlavor;

/**
 *
 * @author NguyenNgocDang
 */
public class Bt_udp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        //nhận dử liệu từ người gửi 
        //công cụ để nhận là:
        
        DatagramSocket serverSocket = new DatagramSocket(8888);
        byte[] receiveData = new byte[1024];
        System.out.println("Waiting......");
        while (true) {            
            //dữ liệu để đâu
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            //thực hiện nhận dl
            serverSocket.receive(receivePacket);///câu cụ thể chưa có
            
            //lấy ra câu từ receivepacket
            String sentence = new String(receivePacket.getData());
            
            //xử lí server, chuyển sang chử hoa
            
            String upsentence = sentence.toUpperCase();
                   
            //gửi upsentence lai người gửi(client)
            
            //phải có gói dữ liệu để gửi
            byte[] sendData = new byte[1024];//dung dê gui
            
            sendData = upsentence.getBytes();
            //tach port và ip
            //int port = receivePacket.getPort();
            //InetAddress ip = receivePacket.getAddress();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,receivePacket.getAddress(), receivePacket.getPort());
            //thực hiện việc gửi gói dữ liệu
            serverSocket.send(sendPacket);
        }
        
    }
    
}
