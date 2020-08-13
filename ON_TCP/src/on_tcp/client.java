/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class client {
    public static void main(String[] args) throws IOException{
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in)); //đọc dữ liệu từ bàn phím
        System.out.println("Nhập dữ liệu: ");
        String readDB = inFromClient.readLine();
        
        Socket clientSocket = new Socket("localhost", 9999);//kết nối đến server đang chạy
        
        DataOutputStream outtoServer = new DataOutputStream(clientSocket.getOutputStream()); //mở luồng outputstream ghi dữ liệu đến server
        outtoServer.writeBytes(readDB + "\n");//dùng luồng trên ghi dử liệu
        
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//nhận dữ liệu từ server
        String sentenceServerChange = inFromServer.readLine();
        System.out.println("Server đã chuyễn: " + sentenceServerChange);
        clientSocket.close();


    }
}
