/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_qlsv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2811);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            int k = 0;    //kiem tra lua chon cua User
            String message = "";    //thong diep gui den Server

            do {
                System.out.println("\n\n---------MENU--------");
                System.out.println("1. Xem danh sach SV");
                System.out.println("2. Them SV moi");
                System.out.println("3. Xem thong tin SV");
                System.out.println("4. Tim nhom SV theo Que quan hoac Nam sinh");
                System.out.println("5. Thoat");
                System.out.print("Ban chon: ");
                k = Integer.parseInt(sc.nextLine());
                dos.writeInt(k);
                switch (k) {
                    case 1: //xem danh sach SV
                        message = dis.readUTF();
                        System.out.println("-> Danh sach SV:");
                        System.out.println(message);
                        break;
                    case 2: //them SV moi
                        System.out.println("Moi ban nhap thong tin Sinh vien moi:");
                        System.out.print("Ten: ");
                        String ten = sc.nextLine();
                        System.out.print("Ngay sinh: ");
                        String ngaysinh = sc.nextLine();
                        System.out.print("Ma sv: ");
                        String masv = sc.nextLine();
                        System.out.print("Que quan: ");
                        String quequan = sc.nextLine();

                        message = ten + "$" + ngaysinh + "$" + masv + "$" + quequan;
                        dos.writeUTF(message);
                        System.out.println("Them sinh vien thanh cong");
                        break;
                    case 3: //xem thong tin SV
                        message = dis.readUTF();
                        System.out.println("-> Thong tin cac SV:");
                        System.out.println(message);
                        break;
                    case 4: //tim nhom SV
                        System.out.println("Ban muon tim theo Que quan hay Nam sinh?");
                        System.out.println("1. Que quan\t\t2. Nam sinh");
                        System.out.print("Ban chon: ");
                        int k2 = Integer.parseInt(sc.nextLine());
                        dos.writeInt(k2);
                        String s;   //que quan hoac nam sinh
                        switch (k2) {
                            case 1: //tim theo Que quan
                                System.out.print("Nhap Que muon tim: ");
                                s = sc.nextLine();
                                dos.writeUTF(s);

                                //lang nghe thong diep tu Server
                                message = dis.readUTF();
                                System.out.println(message);
                                break;
                            case 2: //tim theo Nam sinh
                                System.out.print("Nhap nam sinh muon tim: ");
                                s = sc.nextLine();
                                dos.writeUTF(s);

                                //lang nghe thong diep tu Server
                                message = dis.readUTF();
                                System.out.println(message);
                                break;
                            default:
                                System.out.println("Lua chon khong hop le!");
                                break;
                        }
                        break;
                    case 5: //thoat
                        System.out.println("Cam on ban da su dung chuong trinh!");
                        break;
                    default:
                        System.out.println("Yeu cau khong ro rang, nhap lai!");
                        break;
                }

            } while (k != 5);

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
