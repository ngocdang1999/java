/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_1_ltm;

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
public class BAI_TAP_1_LTM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String clientSentence;
        String upSentence;
        
    //XÂY DỰNG SERVER
    
        ServerSocket SERVERBT1 = new ServerSocket(2929); //SOCKER SERVER
        
        System.out.println("SERVER BÀI TẬP 1 LẬP TRÌNH MẠNG ĐANG CHỜ CLIENT KẾT NỐI: ......");
    
        while (true) {            
            Socket connectionSocket = SERVERBT1.accept();//CHỜ KẾT NỐI
            System.out.println("Kết nối thành công.");
            
            //ĐỌC DỮ LIỆU RA
            //CÔNG CỤ ĐỌC/ LUỒNG ĐỂ ĐỌC
            //MỞ LUỒNG
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            //ĐỌC DỮ LIỆU
            
            String Number1 = inFromClient.readLine(); 
            //xử lý phía server
            //tinh giai thừa
            //ep number tu kieu String sang kieu Integer 
            int Number = Integer.parseInt(Number1); 
            if(Number>=0){
                int giai_thua = 1;
                if (Number == 0 || Number == 1) {
                    giai_thua = 1;
                } else {
                for (int i = 2; i <= Number; i++) {
                    giai_thua *= i;
                }
            }
            outToClient.writeByte(giai_thua);
            System.out.println("Done !!!");
        }
    } 
}
}
