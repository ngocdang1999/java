/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_5_ltm;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.beans.Statement;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenNgocDang
 */
public class qlsvserver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
		//SERVER: PHẢI SỬ DỤNG ServerSocket/Socket
		
		//CLIENT/SERVER
		ServerSocket serverSocket = new ServerSocket(9999);//SOCKET PHÍA SERVER
		
		//NHẬN VỀ
		ObjectInputStream inFromClient;
		
		//GỬI ĐI
		ObjectOutputStream outToClient;
		
		Socket serviceSocket;
		
		int chon;
		System.out.println("Waiting ... for ...");
		//PHẢI CHẠY LIÊN TỤC VÀ CHỜ CLIENT KẾT NỐI ĐẾN
		while(true) {
			
			//KHI CÓ KẾT NỐI ĐẾN
			serviceSocket = serverSocket.accept();//CHỜ VÀ CHẤP NHẬN MỘT KẾT NỐI
			
			//GỬI QUA CHO SERVER MỘT OBJECT/ĐỐI TƯỢNG
			//NHẬN MỘT ĐỐI TƯỢNG THÌ DÙNG CÔNG CỤ GÌ????
			//khởi tạo
			//serviceSocket.getInputStream(): ĐỌC THÔNG TIN TỪ LUỒNG
			inFromClient = new ObjectInputStream(serviceSocket.getInputStream());
			//ĐỌC
			message message = (message)inFromClient.readObject();
			
			chon = message.getChon();//SỰ LỰA CHỌN CỦA CLIENT
			
			//PHẢI RẺ NHÁNH
		switch (chon) {
			case message.XEM_DANH_SACH:
				
				//XỬ LÝ VÀ TRẢ KẾT QUẢ VỀ CLIENT
				//LẤY LÊN MỘT DS TỪ DB ; GỬI DS VỀ CLIENT
				//ĐỂ GỌN CODE THÌ NÊN VIẾT PHƯƠNG THỨC VÀ GỌI VÀO CHỖ NÀY
				List<SinhVien> listSV = getAllSinhVien();//LẤY DANH SÁCH SV TỪ CSDL
				
				//PHẢI GỬI CÁI DANH SÁCH ĐÓ VỀ CLIENT
				//PHẢI CÓ CÔNG CỤ ĐỂ GỬI
				//KHỞI TẠO:
				//serviceSocket.getOutputStream():LUỒNG ĐỂ GỬI DL
				outToClient = new ObjectOutputStream(serviceSocket.getOutputStream());
				//GỬI
				message.setDsSV(listSV);//ĐƯA DS SV VÀO MESSAGE
				
				outToClient.writeObject(message);
				
				outToClient.flush();//TỐNG ĐẨY DL ĐI
				
				System.out.println("GET list DONE !!!");
				
				break;
				
			case message.THEM_SINH_VIEN:
				
				//XỬ LÝ THÊM MỚI MỘT SV
				
				break;

			default:
				break;
			}
			
			
		}

	}

	//PHƯƠNG THỨC LẤY LÊN DANH SÁCH
	public static List<SinhVien> getAllSinhVien() throws SQLException {
		
		//LẤY DS
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();//
		ResultSet rs;
		//KẾT NỐI ĐẾN CSDL
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM TblSinhVien";//câu truy vấn
		
		//CÔNG CỤ ĐỂ TRUY VẤN
		Statement stmt = (Statement) conn.createStatement();
		//THỰC HIỆN TRUY VẤN
		rs = stmt.executeQuery(sql);//ĐỔ DL VÀO RS
		
		//trong RS SẼ CÓ NHIỀU RECORD
		//LẤY RA TỪNG RECORD MỘT
		while(rs.next()) {
			//MỖI DÒNG LÀ MỘT SINH VIÊN
			SinhVien sinhvien = new SinhVien();
			
			sinhvien.setMssv(rs.getInt("mssv"));
			sinhvien.setTenSV(rs.getString("tensinhvien"));
			sinhvien.setQuequan(rs.getString("quequan"));
			
			//NGÀY
			sinhvien.setNgaysinh(rs.getDate("ngaysinh"));
			
			listSV.add(sinhvien);
		}
		
		//ĐÓNG KẾT NỐI LẠI
		conn.close();
		rs.close();
		
		return listSV;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:jtds:sqlserver://localhost:1433/AT14N01_QLSV";
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
