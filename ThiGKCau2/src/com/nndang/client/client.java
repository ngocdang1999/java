/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nndang.client;

import com.nndang.model.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author NguyenNgocDang
 */
public class client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
        menu();
        int chon;
        System.out.println("Hãy nhập lựa chọn của bạn: ");
        chon = Integer.parseInt(inUser.readLine());
        ObjectOutputStream outToServer;
        ObjectInputStream inFromServer;
        Socket clieSocket = new Socket ("localhost", 9999);
        switch (chon){
            case Message.THEM_NHAN_VIEN_MOI:
                Message message = new Message();
                message.setChon(Message.THEM_NHAN_VIEN_MOI);
                outToServer = new ObjectOutputStream(clieSocket.getOutputStream());
		outToServer.writeObject(message);
                inFromServer = new ObjectInputStream(clieSocket.getInputStream());
                Message reMessage = (Message)inFromServer.readObject();
                break;
            case Message.TIM_KIEM_NHAN_VIEN:
                break;
            case Message.TINH_LUONG:
                break;
            default:
                break;
        }
    }
    
    public static void menu() {
	System.out.println("---------------Menu Chức năng ---------------");
	System.out.println("CHỌN 1, 2, 3, 4");
	System.out.println("1. Thêm một nhân viên mới");
	System.out.println("2. Tìm kiếm nhân viên");
	System.out.println("3. Tính lương nhân viên");
	System.out.println("4. Kết thúc.!");
	System.out.println("---------------Menu Chức năng ---------------");
		
		
	}

}
