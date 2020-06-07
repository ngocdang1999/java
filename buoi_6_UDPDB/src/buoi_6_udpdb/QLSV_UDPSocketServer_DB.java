package buoi_6_udpdb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLSV_UDPSocketServer_DB {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DatagramSocket receiverSocket = new DatagramSocket(7788);

		byte[] receiveBuff, sendBuff;

		DatagramPacket receivePacket, sendPacket;
		
		ObjectOutputStream outToReceiver;

		int luachon;
		System.out.println("Waiting ...");
		// CHỜ VÀ NHẬN
		while (true) {

			receiveBuff = new byte[1024];

			receivePacket = new DatagramPacket(receiveBuff, receiveBuff.length);

			receiverSocket.receive(receivePacket);// NHẬN

			// NHẬN ĐỐI TƯỢNG
			// LUỒNG ĐỂ ĐỌC: CHỨA DL TỪ GÓI receivePacket
			ByteArrayInputStream arrIn = new ByteArrayInputStream(receivePacket.getData());

			// CÔNG CỤ ĐỂ ĐỌC DL TỪ LUỒNG BYTE/KHÔNG PHẢI TỪ KẾT NỐI=> UDP KHÔNG KẾT NỐI
			ObjectInputStream inFromClient = new ObjectInputStream(arrIn);

			Message receiveMessage = (Message) inFromClient.readObject();

			luachon = receiveMessage.getChon();

			// RẺ NHÁNH ĐỂ XỬ LÝ YÊU CẦU TƯƠNG ỨNG
			switch (luachon) {
			case Message.XEM_DANH_SACH:
				// XỬ LÝ ĐỂ XEM DANH SÁCH
				List<SinhVien> listSV = getAllSinhVien();
				
				
				//GỬI VỀ NGƯỜI GỬI
				//PHẢI CÓ GÓI DL ĐỂ CHỨA THÔNG TIN GỬI
				ByteArrayOutputStream arrOut = new ByteArrayOutputStream();
				
				Message sendMessage = new Message();
				sendMessage.setDsSV(listSV);
				
				outToReceiver = new ObjectOutputStream(arrOut);//GHI OBJECT VÀO LUỒNG BYTE
				
				outToReceiver.writeObject(sendMessage);//GHI message VÀO LUỒNG BYTE
				
				
				
				sendBuff = new byte [1024];
				sendBuff = arrOut.toByteArray();//CHUYỂN LUỒNG BYTE SANG MẢNG BYTE
				
				InetAddress address = receivePacket.getAddress();//LẤY IP TỪ GÓI NHẬN
				
				int port = receivePacket.getPort();
				
				sendPacket = new DatagramPacket(sendBuff, sendBuff.length, address, port);
				
				//CÔNG CỤ ĐỂ GỬI 
				receiverSocket.send(sendPacket);//GỬI
				
				break;

			case Message.THEM_SINH_VIEN:
				// XỬ LÝ ĐỂ THÊM MỚI MỘT SINH VIÊN
				SinhVien sv = receiveMessage.setSinhvienAdd();
				
				themSinhVien(sv);//THÊM 1 (TRUE) : 0 (KHÔNG THÊM ĐƯỢC)
				
				break;

			default:
				break;
			}
		}

	}

	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:jtds:sqlserver://localhost:1433/DBQLSV_JAVA";
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

	public static List<SinhVien> getAllSinhVien() throws SQLException {

		// LẤY DS
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();//
		ResultSet rs;
		// KẾT NỐI ĐẾN CSDL
		Connection conn = getConnection();

		String sql = "SELECT * FROM TblSinhVien";// câu truy vấn

		// CÔNG CỤ ĐỂ TRUY VẤN
		Statement stmt = conn.createStatement();
		// THỰC HIỆN TRUY VẤN
		rs = stmt.executeQuery(sql);// ĐỔ DL VÀO RS

		// trong RS SẼ CÓ NHIỀU RECORD
		// LẤY RA TỪNG RECORD MỘT
		while (rs.next()) {
			// MỖI DÒNG LÀ MỘT SINH VIÊN
			SinhVien sinhvien = new SinhVien();

			sinhvien.setMssv(rs.getInt("mssv"));
			sinhvien.setTenSV(rs.getString("tensinhvien"));
			sinhvien.setQuequan(rs.getString("quequan"));

			// NGÀY
			sinhvien.setNgaysinh(rs.getDate("ngaysinh"));

			listSV.add(sinhvien);
		}

		// ĐÓNG KẾT NỐI LẠI
		conn.close();
		rs.close();

		return listSV;
	}
	
	public static int themSinhVien(SinhVien sv) {
		//CODE ĐỂ THÊM SINH VIÊN
		//ĐÂY LÀ BÀI TẬP VỀ NHÀ
		return 0;
	}

}
