/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_tcp_so;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class CLIENT {
    public static void main(String[] args) throws IOException{
           BufferedReader newBuf = new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Nhap vao 1 chữ số: ");
           String count = newBuf.readLine();
           
           Socket clientSocket = new Socket("localhost", 9999);
           
           DataOutputStream inFormServer = new DataOutputStream(clientSocket.getOutputStream());
           inFormServer.writeBytes(count + "\n");
           
           BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//nhận dữ liệu từ server
            int b = inFromServer.read();
            System.out.println("Server đã chuyễn: " + b);
            clientSocket.close();

           
    }
}
