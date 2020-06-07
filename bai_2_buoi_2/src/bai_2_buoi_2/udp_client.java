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

/**
 *
 * @author NguyenNgocDang
 */
public class udp_client {
    public static void main(String[] args) throws IOException {
        String sentence, BD ;
        String modifiedSentence="";
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        while(true){
        System.out.println("Begin để bắt đầu, Out để kết thúc:");
        BD = scanner.readLine();
        if(BD.equals("Begin") || BD.equals("begin") ){
            System.out.println("Để thoát trò chuyện nhập End.");
            System.out.println("Cuộc trò chuyện bắt đầu: ");
            while(true){
            System.out.print("Tên người dùng:");
            sentence = inFromUser.readLine();
            
            if(sentence.equals("End") || sentence.equals("end")){
                System.out.println("Cuộc trò chuyện đã dừng!!");
                break;
            }
            else{
                DatagramSocket clientSocket = new DatagramSocket();
                byte[] sendData = new byte[1024];
                sendData = sentence.getBytes();
                InetAddress ipAddress = InetAddress.getByName("localhost");
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,ipAddress,9999);
                clientSocket.send(sendPacket);
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                clientSocket.receive(receivePacket);
                modifiedSentence = new String(receivePacket.getData());                
                if( modifiedSentence.equals("End") || modifiedSentence.equals("end")){
                    System.out.println("Cuộc Trò Truyện Đã Dừng");
                    break;
                }
                else{
                    System.out.println("Nhận từ Server:" + modifiedSentence);
                    clientSocket.close();
                }
            }
            }
        }
        else if(BD.equals("Out")){
            System.out.println("Cuộc trò chuyện đã kết thúc, hẹn gặp lại!!");
            return;
        }
        else{
            System.out.println("Bạn sai, vui lòng nhập lại");
        }
        }         
    }
}
