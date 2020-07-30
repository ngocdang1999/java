/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_qlsv;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

    public static void main(String[] args) {
        ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
        //doc file
        try {
            FileReader fr = new FileReader("sinhvien.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                SinhVien sinhvien = new SinhVien(a[0], a[1], a[2], a[3]);
                listSV.add(sinhvien);
            }
            br.close();
            fr.close();

        } catch (Exception e) {
        }

        //khoi tao ket noi
        try {
            ServerSocket myServer = new ServerSocket(2811);
            System.out.println("Da khoi tao Server TCP, cho doi Client ket noi...");
            while (true) {
                Socket socket = myServer.accept();
                System.out.println("Client da ket noi!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                int k = 0;    //lua chon cua Client
                String message = "";       //thong diep gui ve Client

                do {
                    k = dis.readInt();
                    switch (k) {
                        case 1: //xem danh sach SV
                            message = "";
                            for (SinhVien sv : listSV) {
                                message = message + sv.Ten + "\n";
                            }
                            dos.writeUTF(message);
                            break;
                        case 2: //them SV moi
                            message = dis.readUTF();
                            String[] a = message.split("\\$");
                            SinhVien sinhvien = new SinhVien(a[0], a[1], a[2], a[3]);
                            listSV.add(sinhvien);
                            break;
                        case 3: //xem thong tin SV
                            message = "";
                            for (SinhVien sv : listSV) {
                                message = message + sv.ThongTinSV() + "\n";
                            }
                            dos.writeUTF(message);
                            break;
                        case 4: //tim nhom SV
                            message = "";
                            int k2 = dis.readInt();
                            int count;  //kiem tra xem co ton tai sinh vien nhu the hay khong
                            switch (k2) {
                                case 1: //tim theo Que quan
                                    count = 0;
                                    String s = dis.readUTF();   //que quan muon tim
                                    for (SinhVien sv : listSV) {
                                        if (s.equals(sv.QueQuan)) {
                                            message = message + sv.ThongTinSV() + "\n";
                                            count++;
                                        }
                                    }
                                    if (count == 0) {
                                        message = "khong tim thay sinh vien nao!";
                                    }
                                    //gui lai thong diep cho Client
                                    dos.writeUTF(message);
                                    break;
                                case 2: //tim theo Nam sinh
                                    count = 0;
                                    s = dis.readUTF();  //nam sinh muon tim
                                    for (SinhVien sv : listSV) {
                                        String[] array = sv.NgaySinh.split("/");
                                        //array[0] -> ngay sinh
                                        //array[1] -> thang sinh
                                        //array[2] -> nam sinh
                                        if (s.equals(array[2])) {
                                            message = message + sv.ThongTinSV() + "\n";
                                            count++;
                                        }
                                    }
                                    if (count == 0) {
                                        message = "Khong tim thay sinh vien nao!";
                                    }
                                    //gui lai thong diep cho Client
                                    dos.writeUTF(message);
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Yeu cau khong ro rang, nhap lai!");
                            break;
                    }

                } while (k != 5);

            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
