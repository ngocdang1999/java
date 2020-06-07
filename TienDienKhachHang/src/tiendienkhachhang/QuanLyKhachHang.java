/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendienkhachhang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class QuanLyKhachHang {
    ArrayList <KhachHang> list_khachhang;
    
    QuanLyKhachHang(){
        list_khachhang = new ArrayList<>();
    }
    
    public void NhapKhachHang()throws Exception{
        String traloi;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Chọn loại khách hàng: <1. VN VÀ <2. NN: ");
            int Chon = Integer.parseInt(scanner.nextLine());
            switch (Chon){
                case 1: KhachHangVN khv= new KhachHangVN();
                khv.Nhap();
                if(!list_khachhang.contains(khv)){
                    list_khachhang.add(khv);
                    System.out.print("Đã thêm thành công");
                }
                else
                    System.out.print("Trùng mã số");
                break;
                case 2: KhachHangNN khnn = new KhachHangNN();
                khnn.Nhap();
                if(!list_khachhang.contains(khnn)){
                    list_khachhang.add(khnn);
                    System.out.print("Đã thêm thành công");
                }
                else
                    System.out.print("Trùng mã số");
            }
            System.out.print("Ban co nhap tiep hay khong: <t/k> ");
            traloi = scanner.nextLine();
        }while(traloi.equals("t"));
    }
    
    public void XuatKhachHang(){
        for(KhachHang kh:list_khachhang)
            System.out.println(kh.toString());
    }
    
    public void xuatTheoThangNam(int month, int year){
        for (KhachHang kh:list_khachhang){
            if(((kh.getNgay().getMonth() + 1)== month) 
                    && (kh.getNgay().getYear() + 1900) == year)
                System.out.println(kh.toString());
        }
    }
    
    void sortTheoMaSo(){
        Collections.sort(list_khachhang,new Comparator<KhachHang>(){
            public int compare(KhachHang k1, KhachHang k2){
                return k1.getMaKh().compareTo(k2.getMaKh());
            }
        });
    }
    
    void sortTheoThanhTien(){
        Collections.sort(list_khachhang,new Comparator<KhachHang>(){
            public int compare(KhachHang k1, KhachHang k2){
                return k1.tinhThanhTien() > k2.tinhThanhTien()? 1:k1.tinhThanhTien()<k2.tinhThanhTien() ? -1:0;
            }
        });        
    }
}
