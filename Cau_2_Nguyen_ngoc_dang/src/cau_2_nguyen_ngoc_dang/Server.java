/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau_2_nguyen_ngoc_dang;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author NguyenNgocDang
 */
public class Server {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {

            ArrayList<CauHoi> listCH = new ArrayList<CauHoi>();
                try {
                FileReader fr = new FileReader("cauhoi.txt");
                BufferedReader br = new BufferedReader(fr);
                String s = "";
                while ((s = br.readLine())!=null) {
                    String a[] = s.split("\\$");
                    CauHoi ch = new CauHoi(a[0], a[1], a[2]);
                    listCH.add(ch);
                }
                br.close();
                fr.close();
                            
                } catch (Exception e) {
                }
            ServerSocket myServer = new ServerSocket(2800);
            System.out.println("Khoi tao server");
            while (true) {                
                Socket socket = myServer.accept();
                System.out.println("Client da ket noi");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                for(int i=0;i<listCH.size();i++){
                    String messege = "";
                    CauHoi ch = listCH.get(i);
                    String s = ch.Question +"\n"+ch.Suggestion;
                    dos.writeUTF(s);
                    String dap_an = dis.readUTF();
                    if(dap_an.equalsIgnoreCase(ch.Answer)){
                        messege+="Tra loi dung";
                    }else{
                        messege += "Tra loi sai";
                    }
                    dos.writeUTF(messege);
                }
                }
                        
        } catch (Exception e) {
        }
    }
}
