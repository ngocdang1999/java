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
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class CLIENT_BAI_TAP_2_LTM {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //XÂY DỰNG CHƯƠNG TRÌNH CLIENT
        String sentence;
        
        String modifiedSentence;
        
        //ĐỌC MỘT CÂU TỪ BÀN PHÍM
        //CÔNG CỤ/ LUỒNG ĐỌC(READ) DỮ LIỆU TỪ THIẾT BỊ
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Please, input sentence: ");
        sentence = inFromUser.readLine();
        
        //GỬI DỮ LIỆU QUA SERVER ĐANG CHỜ KẾT NỐI
        //PHẢI CÓ MỘT KẾT NỐI ĐẾN SERVER ĐANG CHỜ
        Socket clientSocket = new Socket("localhost", 9999);//ĐÂY LÀ KẾT NỐI ĐẾN SERVER ĐANG CHẠY
        
        //MỞ MỘT CÁI LUỒNG OUTPUT STREAM ĐỂ GHI DỮ LIỆU ĐẾN SERVER
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        //DÙNG LUỒNG TRÊN ĐỂ GHI DỮ LIỆU
        outToServer.writeBytes(sentence + "\n");
        
        //ĐỌC CÂU ĐÃ ĐƯỢC CHUYỂN SANG HOA TỪ SERVER GỬI QUA
        //MỞ LUỒNG
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        //ĐỌC
        modifiedSentence = inFromServer.readLine();
        
        //in ra màn hình
        System.out.println("FROM SERVER: " + modifiedSentence);
        
        clientSocket.close();//ĐÓNG KẾT NỐI ĐẾN SERVER
    }
}
