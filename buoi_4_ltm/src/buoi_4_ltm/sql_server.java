/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_4_ltm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author NguyenNgocDang
 */
public class sql_server {
    public static void main(String[] args) throws SQLException {
        		// TODO Auto-generated method stub
		// SỬ DỤNG PREPARESTATMENT

		Connection conn = null;// KHAI BÁO MỘT KẾT NỐI VÀ KHỞI TẠO = RỖNG

		String url;// CHUỖI KẾT NỐI

		url = "jdbc:jtds:sqlserver://localhost:1433/SIMPLE_HA";// SQL SERVER CHO NÊN CHUỖI KẾT NỐI CÓ DẠNG LÀ

		// VÌ ĐANG SỬ DỤNG DRIVER jtds

		// NẾU ĐANG SỬ DỤNG MYSQL THÌ CHUỖI KẾT NỐI SẼ KHÁC

		conn = DriverManager.getConnection(url, "sa","Dockersql123");

		String sql = "Select emp.Emp_Id, emp.Emp_No, emp.Emp_Name, emp.Dept_Id " + " from Employee emp "
				+ "where emp.Emp_Name like ? and emp.Dept_Id = ?";// %S 20
		                              //1                     //2

		// KHÔNG THỂ SỬ DỤNG Statement
		// MÀ PHẢI SỬ DỤNG
		// PreparedStatement
		
		PreparedStatement preStmt = null;//KHAI BÁO CÔNG CỤ ĐỂ TRUY VẤN
		
		preStmt = conn.prepareStatement(sql);//KHỞI TẠO CÔNG CỤ ĐỂ TRUY VẤN
		
		//BỔ SUNG THÀNH PHẦN CHO CÂU sql trên
		//THAM SỐ THỨ NHẤT
		preStmt.setString(1, "%S");
		
		//THAM SỐ THỨ 2
		preStmt.setInt(2, 20);
		
		//THỰC THI CÂU TRUY VẤN
		ResultSet rs = null;
		rs = preStmt.executeQuery();//ĐỔ DL VÀO rs
		
		//DUYỆT VÀ IN RA MÀN HÌNH
		
		  while (rs.next()) {
	          System.out.println(" ---- ");
	          System.out.println("EmpId : " + rs.getInt("Emp_Id"));
	          System.out.println("EmpNo : " + rs.getString(2));
	          System.out.println("EmpName : " + rs.getString("Emp_Name"));
	      }        
    }
}
