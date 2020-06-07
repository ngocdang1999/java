/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlithuephong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kira
 */
public class QLHoaDon {
    ArrayList<HoaDon> List_HoaDon;
    
    QLHoaDon(){
        List_HoaDon = new ArrayList<>();
    }
    public void NhapHoaDon() throws Exception{
        Scanner sc = new Scanner(System.in);
        String traloi;
        do{
            System.out.println("Nhập Hoá Đơn 1> Hoá Đơn Theo Ngày / 2> Hoá Đơn Theo Giờ");
            int chon = Integer.parseInt(sc.nextLine());
            switch(chon){
                case 1 : HoaDonTheoNgay hdn = new HoaDonTheoNgay();
                        hdn.Nhap();
                        if(!List_HoaDon.contains(hdn)){
                            List_HoaDon.add(hdn);
                            System.out.println("Đã Thêm Thành Công: ");
                        }
                        else 
                            System.out.println("Trùng Mã Số , Xin Nhập Lại:");
                        break;
                case 2: HoaDonTheoGio hdg = new HoaDonTheoGio();
                        hdg.Nhap();
                        if(!List_HoaDon.contains(hdg)){
                            List_HoaDon.add(hdg);
                            System.out.println("Đã Thêm Thành Công: ");
                        }
                        else 
                            System.out.println("Trùng Mã Số , Xin Nhập Lại:");
                        break;
            }
            System.out.println("Bạn Có Muốn Nhập Tiếp: co/ko");
            traloi = sc.nextLine();
        } while(traloi.equals("co"));
    }
    public void XuatKhachhang(){
        for(HoaDon hd:List_HoaDon){
            System.out.println(hd.toString());
        }
    }
    public void TBThanhTien(){
        
    }
    
}
