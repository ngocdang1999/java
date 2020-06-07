/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_2_ltm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class BAI_TAP_2_LTM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String clientSentence;
        String upSentence;

 

        // XÂY DỰNG SERVER ĐỂ CHẠY, VÀ CHỜ KẾT NỐI TỪ CLIENT
        ServerSocket welcomeSocket = new ServerSocket(9999); // ĐÂY LÀ SOCKET SERVER

 

        System.out.println("Hello, welcome to Server, Waiting ...");
        while (true) {
            
            Socket connectionSocket = welcomeSocket.accept();// CHỜ KẾT NỐI TỪ CLIENT ĐẾN
            
            //ĐỌC DỮ LIỆU RA
            //CÔNG CỤ ĐỌC/ LUỒNG ĐỂ ĐỌC
            //MỞ LUỒNG
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
            //ĐỌC DỮ LIỆU
            clientSentence = inFromClient.readLine();
            //xử lý phía server
            //CHUYỂN SANG CHỮ HOA
            upSentence = clientSentence.toUpperCase() + "\n";
            
            //GỬI upSentence CHO CLIENT
            //LUỒNG GHI
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            //gửi dữ liệu hoa
            outToClient.writeBytes(upSentence);
            
            System.out.println("Done !!!");
            
        }    
    }
}
    
