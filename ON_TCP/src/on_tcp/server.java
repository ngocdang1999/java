/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket wellComeSocket = new ServerSocket(9999); //xây dựng server để chạy
        System.out.println("Waiting.........");
        while (true) {            
            Socket conectionSocket = wellComeSocket.accept();//chờ kết nối từ client đến
            System.out.println("Connection True");
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(conectionSocket.getInputStream()));//nhận từ client
            String readDBClient = inFromClient.readLine(); //đọc dử liệu
            String changereadDBClient = readDBClient.toUpperCase() + "\n";
            DataOutputStream outtoClient = new DataOutputStream(conectionSocket.getOutputStream());//gửi về client
            outtoClient.writeBytes(changereadDBClient);
            System.out.println("Done!!!!!!!!");
        }
    }
}

