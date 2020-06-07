/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_3_ltm;

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
public class CLIENT_BAI_TAP_3_LTM {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        String id;
        
        
        System.out.print("Nhap id can tim: ");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        id = inFromUser.readLine();
        
        Socket client = new Socket("localhost",1999);
        DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());
        outToServer.writeBytes(id + "\n");
        
        //Server tra ket qua
        ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());
        Sinhvien kq = (Sinhvien) inFromServer.readObject();
        
        if (kq.getID()!=9999) 
            System.out.println(kq.toString());
        else 
            System.out.println("ID không co");
    }
}
