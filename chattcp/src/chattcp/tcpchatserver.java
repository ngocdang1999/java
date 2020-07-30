/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class tcpchatserver {
    public static void main(String[] args) throws IOException {
        
        Socket serviceSocket=null;//nhấn kết nối đến
        ServerSocket theServer = new ServerSocket(7777);//chờ
        BufferedReader inUser=null;//đọc dử liệu từ bàn phím
        //Đọc dữ liệu từ client gửi qua
        BufferedReader inFormClient = null;
        inUser = new BufferedReader(new InputStreamReader(System.in));
        serviceSocket = theServer.accept();//chờ kết nối đến
        PrintWriter outToclient = new PrintWriter(serviceSocket.getOutputStream());
        inFormClient = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
        
        new ReadFormClient(serviceSocket);
        while (true) {            
            System.out.println("Server: ");
            String theLine = inUser.readLine();
            outToclient.println(theLine);
            outToclient.flush();
        }
    }
    static class ReadFormClient extends Thread{
        BufferedReader in = null;
        String rdata = "";
        public ReadFormClient(Socket socket) throws IOException{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            start();
        }
    public void run(){
        try{
            while ((rdata = in.readLine()) != null){
                System.out.println("Client:" + rdata);
        }
    }
        catch (IOException e){
            e.printStackTrace();
        }
            
    }
}
}

 
        


