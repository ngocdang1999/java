/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_hoathuong;

import com.sun.security.ntlm.Client;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenNgocDang
 */
public class Server {
    DatagramSocket socket;
    DatagramPacket packet;

    public static void main(String[] args) {
        Server sv = new Server();
        sv.connect();
        
        String s = sv.read();
        s = s.toUpperCase();
        sv.write(s);
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
