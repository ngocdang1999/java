
import com.sun.corba.se.spi.activation.Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NguyenNgocDang
 */
public class QLSVServerTCPDB {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //server phai su dung server socket
        ServerSocket serverSocket = new ServerSocket(9999);//socket phia server
        //chay lien tuc cho client ket noi đến
        Socket serviceSocket;
        ObjectInputStream inFromClient;
        ObjectOutputStream outToClient;
        while (true) {            
            //khi co ket noi den
            serviceSocket = serverSocket.accept();//chờ và chấp nhận một kết nối
            //gui qua cho server mot object
            //nhan mot doi tuong dùng 
            //khởi tạo 
            //doc thong tin tu luong du lieu 
            inFromClient = new ObjectInputStream(serviceSocket.getInputStream());
            //Doc
            Message message = (Message)inFromClient.readObject();
            int chon = message.getChon(); //SU LUA CHON CUA CLIENT
            //phai re nhanh tim su lua chon
            switch (chon){
                case Message.XEM_DANH_SACH:
                    //xu ly ket qua ve client
                    //lay mot ds từ bd/ gui client
                    //de gn code thì viet phuong thuc de goi
                    List<SinhVien> listSV = getAllSinhVien();
                    //gui danh sach về cient
                    //phai có công cu để gửi
                    outToClient = new ObjectOutputStream(serviceSocket.getOutputStream());
                    //gui 
                    outToClient.writeObject(message);
                    outToClient.flush();
                    
                    break;
                case Message.THEM_SINH_VIEN:
                    //xu li them 1 xinh vien
                    break;
                        
            default:
                break;
                       
            }
        }
    }
    //Phuong thuc lay len ds
    public static List<SinhVien> getAllSinhVien() throws SQLException{
        ArrayList<SinhVien> listSV= new ArrayList<SinhVien>();
        ResultSet rs;
        Connection conn = getConnection();
        String sql = "SELECT * FROM SINHVIEN";
        //công cụ để truy vấn
        Statement stmt = conn.createStatement();
        //Thực hiện truy vấn 
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            SinhVien sinhvien = new SinhVien();
            sinhvien.setMSSV(rs.getInt("MASV"));
            sinhvien.setTenSV(rs.getNString("TENSV"));
            sinhvien.setQuequan(rs.getString("QUEQUAN"));
            sinhvien.setNgaySinh((rs.getDate("NGAYSINH")));
            listSV.add(sinhvien);
        }
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
