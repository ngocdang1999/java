/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau_2_nguyen_ngoc_dang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author NguyenNgocDang
 */
public class Client {
    public static void main(String[] args) throws IOException {
            Socket socket = new Socket("localhost", 2800);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            //xu ly
            Scanner sc = new Scanner(System.in);
            String message = "";
            while(true){
                String s = dis.readUTF();
                System.out.println(s);
                System.out.print("Dap an cua ban la: ");
                String dap_an = sc.nextLine();
                dos.writeUTF(dap_an);
                message = dis.readUTF();
                System.out.println(message);
                System.out.println("");
                if(message.equalsIgnoreCase("Tra loi sai")){
                    System.out.println("ro choi ket thuc");
                    socket.close();
                }
            }
    }
}
        
