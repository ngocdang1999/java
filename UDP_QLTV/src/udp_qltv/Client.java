/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_qltv;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {

    DatagramSocket socket;
    DatagramPacket packet;

    public static void main(String[] args) {
        Client cl = new Client();
        cl.connect();

        Scanner sc = new Scanner(System.in);
        String k = "";    //kiem tra xem nguoi dung chon cai gi
        while (!k.equals("4")) {
            System.out.println("\n\n---------------MENU-----------------");
            System.out.println("1. Hien thi thong tin Sach trong Thu Vien");
            System.out.println("2. Muon sach");
            System.out.println("3. Tra sach");
            System.out.println("4. Thoat");
            System.out.print("Ban chon: ");
            k = sc.nextLine();
            cl.write(k);

            switch (k) {
                case "1":   //hien thi thong tin
                    System.out.println(cl.read());
                    break;
                case "2":   //muon sach
                    System.out.print("Nhap ID sach ban can muon: ");
                    String id = sc.nextLine();
                    cl.write(id);
                    
                    System.out.println(cl.read());
                    break;
                case "3":   //tra sach
                    System.out.print("Nhap ID sach ban muon tra: ");
                    id =sc.nextLine();
                    cl.write(id);
                    
                    System.out.println(cl.read());
                    break;
                case "4":
                    System.out.println("Cam on ban da su dung chuong trinh");
                    break;
                default:
                    System.out.println("Chon sai!");
                    break;
            }
        }
    }

    public void connect() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void write(String s) {
        try {
            byte[] data = new byte[1024];
            data = s.getBytes();
            InetAddress ipServer = InetAddress.getByName("localhost");
            packet = new DatagramPacket(data, data.length, ipServer, 2811);
            socket.send(packet);

        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String read() {
        try {
            byte[] data = new byte[1024];
            packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String s = new String(packet.getData()).trim();
            return s;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
