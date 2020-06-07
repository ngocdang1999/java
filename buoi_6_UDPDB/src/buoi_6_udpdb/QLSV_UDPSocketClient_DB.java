package buoi_6_udpdb;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class QLSV_UDPSocketClient_DB {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		// NGƯỜI DÙNG NHẬP VÀO LỰA CHỌN
		DatagramSocket senderSocket;// KHAI BÁO

		DatagramPacket sendPacket, receivePacket;// KHAI BÁO

		byte sendBuff[] = new byte[1024];

		byte receiveBuff[] = new byte[1024];

		ObjectInputStream inFromReceiver;

		ByteArrayOutputStream arrOut;

		ObjectOutputStream outToServer;

		senderSocket = new DatagramSocket();// UDP THÌ KHÔNG CẦN PHẢI XÁC ĐỊNH PORT Ở SOCKET
		int luachon;
		BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
		menu();

		System.out.print("Nhập vào chức năng: ");
		luachon = Integer.parseInt(inUser.readLine());

		// RẼ NHÁNH VÌ CÓ NHIỀU LỰA CHỌN/CHỨC NĂNG
		switch (luachon) {
		case Message.XEM_DANH_SACH:
			// XỬ LÝ ĐỂ YÊU CẦU XEM DANH SÁCH
			// ĐỂ GỬI ĐI YÊU QUA SERVER THÌ ĐỐI VỚI UDP CHÚNG TA PHẢI CÓ GÌ?

			Message sendMessage = new Message();
			sendMessage.setChon(Message.XEM_DANH_SACH);

			// RẮC RỐI NÀY ĐỐI VỚI UDP
			// TRUYỀN /GỬI ĐỐI TƯỢNG THÌ CHÚNG TA PHẢI SỬ DỤNG GÌ?
			// MẢNG BYTE => PHẢI CHUYỂN OBJ SANG BYTE
			// LUỒNG BYTE ĐỂ GHI
			arrOut = new ByteArrayOutputStream();

			// CÔNG CỤ ĐỂ GHI ĐỐI TƯỢNG VÀO MẢNG BYTE
			outToServer = new ObjectOutputStream(arrOut);
			// GHI
			outToServer.writeObject(sendMessage);// GHI ĐỐI TƯỢNG VÔ LUỒNG BYTE

			sendBuff = arrOut.toByteArray();// CHUYỂN LUỒNG BYTE CHỨA ĐỐI TƯỢNG VÀO MẢNG BYTE

			InetAddress ipAddress = InetAddress.getByName("localhost");
			// XÂY DỰNG GÓI CHỨA THÔNG TIN ĐỂ GỬI
			sendPacket = new DatagramPacket(sendBuff, sendBuff.length, ipAddress, 7788);

			// ĐÃ CÓ GÓI DL CHỨA THÔNG TIN
			// GỬI
			senderSocket.send(sendPacket);// GỬI

			// NHẬN VỀ DANH SÁCH SINH VIÊN
			// GÓI DL ĐỂ NHẬN
			receiveBuff = new byte[1024];
			receivePacket = new DatagramPacket(receiveBuff, receiveBuff.length);

			// XỬ LÝ NHẬN
			senderSocket.receive(receivePacket);// NHẬN

			// LUỒNG BYTE CHỨA DL ĐỂ ĐỌC
			ByteArrayInputStream arrIn = new ByteArrayInputStream(receivePacket.getData());

			// LẠI PHẢI ĐỌC ĐỐI TƯỢNG
			inFromReceiver = new ObjectInputStream(arrIn);

			Message receiveMessage = (Message) inFromReceiver.readObject();

			List<SinhVien> listSV = receiveMessage.getDsSV();

			// IN RA MÀN HÌNH DANH SÁCH SV
			for (SinhVien x : listSV) {
				System.out.println(x.toString());
			}
			break;
		case Message.THEM_SINH_VIEN:
			// XỬ LÝ ĐỂ YÊU CẦU THÊM MỚI MỘT SINH VIÊN
			//nhaafp vào SINH VIÊN TỪ BÀN PHÍM
			SinhVien sv = nhapSinhVien();
			
			Message sendMessageAdd = new Message();
			sendMessageAdd.setChon(Message.THEM_SINH_VIEN);//CHỨC NĂNG
			
			//ĐƯA SINH VIÊN VÀO TIN NHẮN
			sendMessageAdd.setSinhvienAdd(sv);
			
			// LUỒNG BYTE
			arrOut = new ByteArrayOutputStream();
			
			outToServer = new ObjectOutputStream(arrOut);
			
			outToServer.writeObject(sendMessageAdd);
			
			sendBuff = new byte[1024];
			
			sendBuff = arrOut.toByteArray();
			
			sendPacket = new DatagramPacket(sendBuff, sendBuff.length, 
					InetAddress.getByName("localhost"), 7788);
			
			senderSocket.send(sendPacket);//GỬI

			break;

		default:
			break;
		}

	}

	// PHƯƠNG THỨC MENU
	public static void menu() {
		System.out.println("---------------Menu Chức năng ---------------");
		System.out.println("CHỌN 1, 2, 3, 4");
		System.out.println("1. Xem Danh sách Sinh Viên");
		System.out.println("2. Thêm một Sinh Viên mới");
		System.out.println("3. Xóa một Sinh Viên");
		System.out.println("4. Cập nhật thông tin của một sinh viên");
		System.out.println("5. Tìm kiếm một sinh viên");
		System.out.println("6. Kết thúc.!");
		System.out.println("---------------Menu Chức năng ---------------");

	}
	
	public static SinhVien nhapSinhVien() throws ParseException {
		SinhVien sv = new SinhVien();
		//NHẬP THÔNG TIN CỦA SINH VIÊN TỪ BÀN PHÍM
		Scanner nhap = new Scanner(System.in);//công cụ để nhập từ bàn phím
		
		System.out.print("Nhập mã sinh viên: ");
		sv.setMssv(nhap.nextInt());
		
		System.out.print("Nhập tên sinh viên: ");
		sv.setTenSV(nhap.nextLine());
		
		System.out.print("Nhập ngày sinh: ");//NGÀY NÊN CẨN THẬN
		String strNgaysinh = nhap.nextLine().trim();//NHẬP VÀO THÌ MÌNH LÀ NGƯỜI VIỆT
		//dd/MM/yyyy: 20/10/2020
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");//TẠO CÔNG CỤ ĐỂ ĐỊNH DẠNG
		//NGÀY VIỆT NAM
		
		sv.setNgaysinh(format.parse(strNgaysinh));
		
		System.out.print("Nhập quê quán: ");
		sv.setQuequan(nhap.nextLine());
		
		nhap.close();
		
		return sv;
	}

}
