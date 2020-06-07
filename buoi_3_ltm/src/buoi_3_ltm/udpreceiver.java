/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_3_ltm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author NguyenNgocDang
 */
public class udpreceiver {
    public static void main(String[] args) throws SocketException, IOException {
        // TODO Auto-generated method stub

		// GIAO THỨC UDP - CHỈ CẦN XÁC ĐỊNH IP/PORT THÌ SẼ THỰC ĐƯỢC VIỆC GỬ VÀ NHẬN DL

		// KHÔNG PHẢI LÀ CLIENT/SERVER
		// CÔNG CỤ ĐỂ NHẬN/GỬI LẠI DL QUA SENDER
		DatagramSocket receiverSocket;// khai báo

		// GÓI DL/TIN
		DatagramPacket receivePacket, sendPacket;// KHAI BÁO GÓI ĐỂ GỬI/NHẬN

		// TIN NHẮN NHẬN/GỬI
		String receiveStr, sendStr;

		// ĐỊA CHỈ CỦA NGƯỜI GỬI
		InetAddress ipAddress;

		// PORT
		int port;

		// CÔNG CỤ DÙNG ĐỂ NHẬP TỪ BÀN PHÍM ĐỂ CHAT TRỞ LẠI NGƯỜI GỬI
		BufferedReader inUser;// KHAI BÁO

		//
		inUser = new BufferedReader(new InputStreamReader(System.in));// KHỞI TẠO CÔNG CỤ NHẬP
		System.out.println("Waitting ...");

		// SỬ DỤNG CÔNG CỤ ĐỂ NHẬN - CHƯA KHỞI TẠO
		receiverSocket = new DatagramSocket(7777);// KHỞI TẠO CÔNG CỤ NHẬN/GỬI

		while (true) {

			// NHẬN - KHỞI TẠO GÓI NHẬN\
			byte[] buffReceive = new byte[1024];
			byte[] buffSend = new byte[1024];

			receivePacket = new DatagramPacket(buffReceive, buffReceive.length);// ĐƠN GIẢN HƠN SEND

			// THỰC HIỆN VIỆC NHẬN DL

			// THỰC HIỆN NHẬN
			receiverSocket.receive(receivePacket);

			// TÁCH DL RA
			receiveStr = new String(receivePacket.getData());

			System.out.println(receiveStr);

			// CHAT TRỞ LẠI
			System.out.print("Hãy nhập vào nội dung để gửi: ");
			sendStr = inUser.readLine();

			// GỬI TIN NHẮN CHO NGƯỜI GỬI

			// KHỞI TẠO GÓI GỬI
			buffSend = sendStr.getBytes();// ĐỔ DL NHẬP TỪ BÀN PHÍM VÀO MẢNG BYTE

			// ĐỊA CHỈ NGƯỜI GỬI???????; PORT???

			// TÁCH IP, PORT TỪ GÓI receivePacket
			ipAddress = receivePacket.getAddress();
			port = receivePacket.getPort();

			sendPacket = new DatagramPacket(buffSend, buffSend.length, ipAddress, port);// PHỨC TẠP HƠN NHẬN

			// THỰC HIỆN VIỆC GỬI
			receiverSocket.send(sendPacket);

		}

    }
}
