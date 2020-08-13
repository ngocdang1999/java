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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class SERVER {
    public static void main(String[] args) throws IOException{
        ServerSocket newSocket = new ServerSocket(9999);
        System.out.println("Waiting.......");
        while (true) {            
            Socket connectionSocket = newSocket.accept();
            
            BufferedReader inFormClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            String newBD = inFormClient.readLine();
            
            int a = Integer.parseInt(newBD);
            int giaithua = 1;
            if (a == 0 || a==1){
                giaithua = 1;
            }else{
            for (int i=1;i<=a;i++){
                giaithua = giaithua*i;
                System.out.println("số: " + giaithua);
            }
        }
            DataOutputStream changeDB = new DataOutputStream(connectionSocket.getOutputStream());
            changeDB.writeByte(giaithua);
            System.out.println("Done.......");
        }
    }
}
