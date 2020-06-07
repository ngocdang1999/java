/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_4_ltm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NguyenNgocDang
 */
public class sql_client {
    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
		//TỚI ĐÂY CHƯA Ạ?
		
		//TEST THỬ XEM CÓ KẾT NÓI ĐỂ DATABASE SIMPLEHR ĐƯỢC HAY KHÔNG?
		
		//CHUẨN BỊ TRÌNH ĐIỀU KHIỂN - DRIVER
		
		//ĐEM DRIVER VÀO ECLIPSE?? TỚI ĐÂY CHƯA Ạ?
		
		//CÁI NÀY LÀ DRIVER CỦA SQLSERVER
		
		//MYSQL - LÊN GG ĐỂ TÌM DRIVER ĐÚNG VỚI PHIÊN BẢN MYSQL CỦA BẠN VÀ LÀM NHƯ TRÊN
		
		//DATABASE: SIMPLEHR
		
		//TẠO KẾT NỐI ĐẾN SIMPLEHR
		Connection conn = null;//KHAI BÁO MỘT KẾT NỐI VÀ KHỞI TẠO = RỖNG
		
		String url;//CHUỖI KẾT NỐI
		
		url = "jdbc:jtds:sqlserver://localhost:1433/SIMPLE_HA";//SQL SERVER CHO NÊN CHUỖI KẾT NỐI CÓ DẠNG LÀ
		
		//VÌ ĐANG SỬ DỤNG DRIVER jtds
		
	//NẾU ĐANG SỬ DỤNG MYSQL THÌ CHUỖI KẾT NỐI SẼ KHÁC
		
		conn = DriverManager.getConnection(url, "sa","Dockersql123");
		
		//TỚI ĐÂY CHƯA Ạ?
		
		System.out.println(conn.toString());
		
		//ĐÃ CÓ KẾT NỐI RỒI
		
		//SẼ SỬ DỤNG KẾT NỐI ĐỂ THỰC HIỆN CÁC THAO TÁC NHƯ TRUY VẤN, INSERT, DELETE, UPDATE
		//LÊN CÁC BẢNG CỦA CSDL SIMPLEHR
		
		//TRUY VẤN ĐẾN 1 BẢNG CỦA SIMPLEHR, EMPLOYEE
		
		//TẠO CÔNG CỤ ĐỂ TRUY VẤN
		Statement stmt = conn.createStatement();//
		
		//TRUY VẤN 
		ResultSet rs = null;
		
		//ĐÂY LÀ CÂU TRUY VẤN TRONG SQL
		String sql = "Select Emp_Id, Emp_No, Emp_Name from Employee";
		
		rs = stmt.executeQuery(sql);//LẤY VỀ MỘT SỐ DÒNG DỮ LIỆU// ĐỔ VÀO CÁI rs
		
		//KIỂM TRA RESULTSET XEM CÓ DL HAY KHÔNG?
		
		//SẼ DUYỆT
		//LỆNH LẶP
		while(rs.next()) {//CÓ CÒN DÒNG  DL NÀO HAY KHÔNG?
			
			//GIẢ SỬ CHÚNG TA MUỐN LẤY RA CỘT THỨ 2
			//DL KIỂU CHUỖI
			String no = rs.getString(2);//ĐỐI SỐ LÀ THỨ TỰ CỦA CỘT
			
			//LẤY RA DL CỦA CỘT SỐ 1: DL LÀ KIỂU int
			
			int id = rs.getInt(1);//ĐỐI SỐ LÀ CỘT 1; DỮ LIỆU LÀ SỐ
			
			//LẤY DL CỦA CỘT TÊN
			String name = rs.getString("Emp_Name");
			
			System.out.println("-------------------------");
			System.out.println("Emp Id: " + id);
			System.out.println("Emp No: " + no);
			System.out.println("Emp Name: " + name);
			
		}
		
		//ĐÓNG KẾT NỐI: VÌ SAO: TRÁNH LÃNG PHÍ TÀI NGUYÊN
		conn.close();//đóng
		
		//NGOÀI RA THÌ CÒN: UPDATE, INSERT, DELETE
		
		//stmt.executeUpdate(sql); sql dành cho insert; update, delete
		
		//TIẾP THEO SỬ DỤNG PreparedStatement: TẠI SAO NÊN SỬ DỤNG CÁI NÀY
		
		
		
		
		
    }
}
