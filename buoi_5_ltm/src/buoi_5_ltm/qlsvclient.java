/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_5_ltm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author NguyenNgocDang
 */
public class qlsvclient {
    public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//CÁC BẠN CÙNG LÀM NHÉ
		//Socket
		//CÓ KẾT NỐI
		//PHẢI XÁC ĐỊNH ĐƯỢC IP/PORT
		
		//DỮ LIỆU: OBJECT/ĐỐI TƯỢNG
		
		//PHẢI CÓ MENU CHỨC NĂNG ĐỂ NGƯỜI DÙNG CHỌN
		//NGƯỜI DÙNG SẼ CHỌN MENU TỪ BÀN PHÍM
		//CÔNG CỤ ĐỂ NHẬP
		BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
		menu();
		
		int chon;//BIẾN ĐỂ LƯU SỰ LỰA CHỌN CỦA CLIENT
		//CHO NGƯỜI DÙNG NHẬP
		//NHẬP MỘT SỐ NGUYÊN 1, 2, 3, 4, 5, ...
		System.out.print("Hãy nhập vào một lựa chọn 1, 2, 3, 4, ...:");
		chon = Integer.parseInt(inUser.readLine());
		
		//XỬ LÝ TIẾP CHỨC NĂNG
		
		//LIÊN QUAN ĐẾN ĐỐI TƯỢNG => TRUYỀN/NHẬN SẼ CÓ ĐỐI TƯỢNG
		
		//GHI/ĐỌC SINH VIÊN => TRUYỀN/NHẬN SINH VIÊN: ĐỐI TƯỢNG SINH VIÊN
		//CLASS SINHVIEN
		ObjectOutputStream outToServer;//CÔNG CỤ ĐỂ GỬI ĐỐI TƯƠNG ĐẾN SERVER
		
		//CÔNG CỤ NHẬN
		ObjectInputStream inFromServer;//
		Socket clientSocket = new Socket("localhost", 9999);//CÔNG CỤ ĐỂ MỞ LUỒNG/KẾT NỐI ĐẾN SERVER
		
		//CÓ NHIỀU LỰA CHỌN => NÊN SẼ PHẢI SỬ LÝ RẼ NHÁNH
		switch (chon) {
		//XỬ LÝ SỰ LỰA CHỌN ĐẦU TIÊN:
				//1. XEM DANH SÁCH SINH VIÊN
		case message.XEM_DANH_SACH:
			//CÁC BẠN CÓ THỂ XỬ LÝ KHÁC
			message message = new message();//TẠO RA MỘT TIN NHẮN MỚI
			//THIẾT LẬP/XÁC ĐỊNH CỦA LỰA CHỌN NGƯỜI DÙNG
			message.setChon(message.XEM_DANH_SACH);//TÔI CẦN XEM DS SINH VIÊN
			//ĐỂ TRUYỀN QUA SERVER
			//TRUYÊN QUA SERVER
			//TCP SOCKET MUỐN TRUYỀN THÌ PHẢI CÓ CÔNG CỤ ĐỂ TRUYỀN
			//CÔNG CỤ LÀ MỘT SOCKET
			
			//ĐANG MUỐN GỬI ĐI LÀ MỘT ĐỐI TƯỢNG
			//CHÚNG TA PHẢI CÓ CÔNG CỤ ĐỂ GỬI ĐỐI TƯỢNG
			//KHỞI TẠO
			//clientSocket.getOutputStream(): MỞ LUỒNG GHI/GỬI ĐẾN SERVER
			outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			outToServer.writeObject(message);//GỬI ĐỐI TƯỢNG message đi
			
			//NHẬN VỀ
			//CODE SAU
			//KHỞI TẠO
			inFromServer = new ObjectInputStream(clientSocket.getInputStream());
			
			//NHẬN 
			message recieveMessage = (message)inFromServer.readObject();
			
			List<SinhVien> listSV  = recieveMessage.getDsSV();//lấy dssv
			
			//IN RA MÀN HÌNH
			for(SinhVien sv : listSV) {
				
				System.out.println(sv.toString());
				
			}
			
			
			
			break;

		default:
			break;
		}
		
		
		
		

	}
	
	//PHƯƠNG THỨC MENU
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
}
