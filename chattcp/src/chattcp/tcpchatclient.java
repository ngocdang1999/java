/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattcp;

import static com.sun.glass.ui.Application.run;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenNgocDang
 */
public class tcpchatclient {
    public static void main(String[] args) throws IOException {
        Socket theClient = new Socket("localhost", 7777);//kết nối đến server
        BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));//đọc từ bàn phím
        PrintWriter outoServer = new PrintWriter(theClient.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(theClient.getInputStream()));
        
        new ReadFromServer((theClient));
        
        while (true) {            
            System.out.println("Client: ");
            String theLine = inUser.readLine();
            outoServer.println(theLine);
            outoServer.flush();
        }
        
    }
    static class ReadFromServer extends Thread{
        BufferedReader in = null;
        String rdata = "";
        public ReadFromServer(Socket socket) throws IOException{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            start();
        }
        public void run(){
            try {
                while((rdata = in.readLine()) != null);
                System.out.println("Server: " + rdata);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
                
    }
}
