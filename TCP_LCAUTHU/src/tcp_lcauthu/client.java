/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_lcauthu;

import com.sun.security.ntlm.Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenNgocDang
 */
public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1111);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            int k = 0;        //kiem tra xem nguoi dung nhap cai gi
            while (k != 4) {
                System.out.println("---------------MENU--------------");
                System.out.println("1. Them cau thu moi");
                System.out.println("2. Xem thong tin cac cau thu");
                System.out.println("3. Tinh tong luong thang cua cau thu bat ky");
                System.out.println("4. Thoat");
                System.out.print("Ban chon: ");
                k = Integer.parseInt(sc.nextLine());
                dos.writeInt(k);

                switch (k) {
                    case 1:
                        System.out.print("Nhap ID: ");
                        String id = sc.nextLine();
                        System.out.print("Nhap Ten: ");
                        String ten = sc.nextLine();
                        System.out.print("Nhap Nam sinh: ");
                        int namsinh = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhap Vi tri: ");
                        String vitri = sc.nextLine();
                        System.out.print("Nhap Luong thang mac dinh: ");
                        float luongthangmacdinh = Float.parseFloat(sc.nextLine());

                        String s = id + "$" + ten + "$" + namsinh + "$" + vitri + "$" + luongthangmacdinh;
                        dos.writeUTF(s);

                        System.out.println(dis.readUTF());
                        break;
                    case 2:
                        System.out.println("Thong tin tat ca cac cau thu:");
                        System.out.println(dis.readUTF());
                        break;
                    case 3:
                        System.out.print("Nhap ID cua cau thu do: ");
                        id = sc.nextLine();
                        System.out.print("Nhap so tran thi dau trong thang: ");
                        int sotran = Integer.parseInt(sc.nextLine());
                        dos.writeUTF(id);
                        dos.writeInt(sotran);
                        
                        System.out.println("Tong luong thang cua cau thu do la: "+dis.readFloat());
                        break;
                    case 4:
                        System.out.println("Cam on ban da su dung chuong trinh!");
                        break;
                    default:
                        System.out.println("Nhap sai!");
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
