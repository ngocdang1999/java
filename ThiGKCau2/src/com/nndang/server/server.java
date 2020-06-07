/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nndang.server;

import com.nndang.model.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NguyenNgocDang
 */
public class server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9999);
		//NHẬN VỀ
		ObjectInputStream inFromClient;
		
		//GỬI ĐI
		ObjectOutputStream outToClient;
		
		Socket serviceSocket;
		
		int chon;
		System.out.println("Waiting .......");
        while (true) {            
            serviceSocket = serverSocket.accept();
            System.out.println("Kết nối thành công.");
            inFromClient = new ObjectInputStream(serviceSocket.getInputStream());
            Message message = (Message)inFromClient.readObject();
            chon = message.getChon();
            switch (chon) {
                case Message.THEM_NHAN_VIEN_MOI:
                    break;
                case Message.TIM_KIEM_NHAN_VIEN:
                    break;
                case Message.TINH_LUONG:
                    break;
                default:
                    break;         
            }
        }
    }
public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:jtds:sqlserver://localhost:1433/QLNVienNew";
		String user = "sa";
		String password = "Dockersql123";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
