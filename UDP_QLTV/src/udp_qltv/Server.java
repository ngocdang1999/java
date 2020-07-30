/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_qltv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

    DatagramSocket socket;
    DatagramPacket packet;

    public static void main(String[] args) {
        //doc file
        ArrayList<Sach> listSach = new ArrayList<Sach>();
        try {
            FileReader fr = new FileReader("sach.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                //a[0]: ID
                //a[1]: ten sach
                //a[2]: NXB
                //a[3]: tong so luong
                //a[4]: so luong da muon
                Sach sach = new Sach(a[0], a[1], a[2], Integer.parseInt(a[3]), Integer.parseInt(a[4]));
                listSach.add(sach);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }

        //khoi tao ket noi
        Server sv = new Server();
        sv.connect();

        String k = "";
        String message = "";
        while (!k.equals("4")) {
            k = sv.read();

            switch (k) {
                case "1":   //hien thi thong tin
                    String ThongTinSach = "";
                    for (Sach sach : listSach) {
                        ThongTinSach += sach.ThongTinChiTiet();
                    }
                    sv.write(ThongTinSach);
                    break;
                case "2":   //muon sach
                    String id = sv.read();
                    int count = 0;    //kiem tra xem co sach nao co ID nhu the khong
                    for (Sach sach : listSach) {
                        if (sach.ID.equals(id) && sach.SoLuongChoMuon < sach.TongSoLuong) {
                            message = "Muon thanh cong!";
                            count++;
                            sach.SoLuongChoMuon++;
                            break;
                        }
                    }
                    if (count == 0) {
                        message = "Trong Thu Vien khong con sach nay!" ;
                    }
                    sv.write(message);
                    break;
                case "3":   //tra sach
                    id = sv.read();
                    count=0;
                    for (Sach sach : listSach) {
                        if(sach.ID.equals(id)){
                            message="Tra sach thanh cong!";
                            count++;
                            sach.SoLuongChoMuon--;
                            break;
                        }
                    }
                    if(count==0){
                        message="Tra sach that bai, trong Thu vien khong co loai sach nay!";
                    }
                    
                    sv.write(message);
                    break;
                default:
                    break;
            }

        }
    }

    public void connect() {
        try {
            socket = new DatagramSocket(2811);
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void write(String s) {

        byte[] data = new byte[1024];
        data = s.getBytes();
        InetAddress ipClient = packet.getAddress();
        int portClient = packet.getPort();
        packet = new DatagramPacket(data, data.length, ipClient, portClient);
        try {
            socket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
