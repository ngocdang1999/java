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

/**
 *
 * @author NguyenNgocDang
 */
public class udpsenderchat {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

		// UDP THÌ SỬ DỤNG CLASS JAVA?

		// UDP THÌ KHÔNG THEO MÔ HÌNH CLIENT/SERVER

		// TCP MỚI LÀ MÔ HÌNH CLIENT/SERVER

		// NHẬP CÂU TỪ BÀN PHÍM
		BufferedReader inUser;// KHAI BÁO BIẾN

		// CÔNG CỤ ĐỂ GỬI/NHẬN GÓI TIN/DL
		DatagramSocket senderSocket = null;

		// DATAGRAMPACKET: ĐÓNG GÓI DL GỬI ĐI - CHỨA DL NHẬN VỀ
		DatagramPacket sendPacket;// GÓI DÙNG ĐỂ GỬI DL ĐI

		// TÀI VÌ CHÚNG TA ĐANG CHAT NÊN:
		DatagramPacket receivePacket;// GÓI ĐỂ NHẬN DL VỀ

		// KHI MÀ CÁC GỬI TIN NHẮN ĐI/ NHẬN TIN NHẮN VỀ
		String sendStr, receiveStr;// TIN NHẮN/CHUỖI

		// KHAI BÁO MỘT CÁI ĐỊA CHỈ IP
		InetAddress ipAddress;

		// MUỐN SỬ DỤNG THÌ PHẢI KHỞI TẠO

		inUser = new BufferedReader(new InputStreamReader(System.in));// KHỞI TẠO CÔNG CỤ NHẬP

		while (true) {

			System.out.print("Nhập vào thông tin để gửi đi: ");
			sendStr = inUser.readLine();

			// CÓ DL RỒI => ĐÓNG GÓI TIN NHẮN
			// KHỞI TẠO PACKET
			byte[] buffSend = new byte[1024];
			byte[] buffReceive = new byte[1024];

			buffSend = sendStr.getBytes();// ĐỔ DL VÀO MẢNG BYTE

			// LẤY ĐỊA CHỈ IP CỦA RECEIVER
			ipAddress = InetAddress.getByName("localhost");

			sendPacket = new DatagramPacket(buffSend, buffSend.length, ipAddress, 7777);
			// HOÀN THÀNH VIỆC ĐÓNG GÓI DL ĐỂ CHUẨN BỊ CHO VIỆC GỬI ĐI

			// GỬI - NHƯNG CHƯA KHỞI TẠO CÔNG CỤ
			senderSocket = new DatagramSocket();

			// THỰC HIỆN GỬI
			senderSocket.send(sendPacket);

			// CHAT - NHẬN VỀ
			// KHỞI TẠO GÓI NHẬN
			receivePacket = new DatagramPacket(buffReceive, buffReceive.length);

			// THỰC HIỆN VIỆC NHẬN
			// SỬ DỤNG CỘNG CỤ NHẬN
			senderSocket.receive(receivePacket);

			// TÁCH DỮ LIỆU
			receiveStr = new String(receivePacket.getData());

			// IN RA MÀN HÌNH
			System.out.println(receiveStr);

		}
    }
}
