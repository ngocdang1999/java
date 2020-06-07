
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NguyenNgocDang
 */
public class QLSVClientTCPDB {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //có kết nối client server
        //phai sac dinh duoc ip va port thực hiện bắc tay 3 buoc truyên dư lieu
        
        //du lieu là db
        //phai co chuc nang de nguoi dung chon 
        //nguoi dung se chon menu tu ban phim
        //cong cu de nhap
        BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
       
        menu();
        //cho nguoi dung nhap
        int chon;//bien de luuu su lua chon cua client
        System.out.println("Hay nhap so nguyen");
        chon = Integer.parseInt(inUser.readLine());
        
        Socket clientSocket = new Socket("localhost", 9999);
        ObjectOutput outToServer;//cong cu de gui den server
        ObjectInputStream inFromserver;

//xu lu chuc nang
        //lien quan den doi tuong => truyen và nhận sẽ có đối tượng
        //ghi/doc sinh vien => truyền và nhận đối tượng sinh viên
        //class sinh viên
        //xu ly su lua chon dau tiên
        //1. xem danh sach sinh vien
        switch (chon){
            case Message.XEM_DANH_SACH:
                Message message = new Message();//tao ra mot tin nhan moi de truyen qua server
                message.setChon(Message.XEM_DANH_SACH);//toi can xem ds sinh vien
                //đễ truyền qua server
                //đang muon gui di la mot doi tuong
                //chung ta phai có công cu để gửi đối tượng
                //khoi tao 
                outToServer = new ObjectOutputStream(clientSocket.getOutputStream());//mo luong ghi hay gui den server
                outToServer.writeObject(message);//gui doi tuong message di
                inFromserver = new ObjectInputStream(clientSocket.getInputStream());
                Message recieveMessage= (Message)inFromserver.readObject();
                List<SinhVien> listSV = recieveMessage.getDsSV();
                for(SinhVien sv : listSV){
                    System.out.println(sv.toString());
                }
                break;
            default:
                break;
            
        }
        
        
        
        
    }
        public static void menu(){
            System.out.println("---Menu chức năng--------");
            System.out.println("Chọn từ 1,2,3,4,: ");
            System.out.println("1. Xem danh sach sinh vien");
            System.out.println("2. Them môt sinh vien mới");
            System.out.println("3. Xóa một sinh viên");
            System.out.println("4. Cập nhật thông tin sinh viên");
            System.out.println("5. Tìm kiếm một sinh viên");
            System.out.println("6. Kết thúc");
            System.out.println("-------------------------");   
        }
    }

