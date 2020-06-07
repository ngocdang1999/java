/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_3_ltm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenNgocDang
 */
public class BAI_TAP_3_LTM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        int n, id, tuoi;
        String ten;
        int checkid;
        File file = new File("src/bai_tap_3_ltm/Input.txt");
        
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        List<Sinhvien> dssv = new ArrayList<>();
        
        FileOutputStream fos = new FileOutputStream(file); 
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        System.out.print("Nhap so SV: ");
        n = Integer.parseInt(scanner.readLine());
       
        
        for (int  i=1; i<=n; i++){
            
            System.out.print("Nhap id: ");
            id = Integer.parseInt(scanner.readLine());
            System.out.print("Nhap tuoi: ");
            tuoi = Integer.parseInt(scanner.readLine());
            System.out.print("Nhap ten: ");
            ten = scanner.readLine();
            
            dssv.add(new Sinhvien(id,tuoi,ten));
        }
        
        oos.writeObject(dssv);
        dssv.clear();
        
        // Cho tin hieu tu client
        System.out.println("Chờ kết nối");
        ServerSocket welcome = new ServerSocket(1999);
        while (true){
            Socket connect = welcome.accept();
            
            BufferedReader inFromClinet = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            checkid = Integer.parseInt(inFromClinet.readLine());
            
        
            //tim kiem du lieu tu file
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            dssv = (List<Sinhvien>) ois.readObject();
            
            Sinhvien kq = new Sinhvien();
            for (Sinhvien i : dssv)
                if (i.getID()==checkid){
                    kq = i;
                    break;
                }
          
            ObjectOutputStream outToClient = new ObjectOutputStream(connect.getOutputStream());
            outToClient.writeObject(kq);
        }  
    
    }
}
    
