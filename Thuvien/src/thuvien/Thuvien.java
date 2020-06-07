/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuvien;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class Thuvien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<sachgiaokhoa> arrsachgiaokhoa = new ArrayList<>();
        ArrayList<sachthamkhao> arrsachthamkhao = new ArrayList<>();
        
        int soSachGiaoKhoa, soSachThamKhao;
        
        double tongTienSachGiaoKhoa = 0, tongTienSachThamKhao = 0, tongDonGiaSachThamKhao = 0, trungBinhCongDonGia = 0;
        Scanner scanner = new Scanner(System.in);
         
        System.out.print("Nhập số sách giáo khoa: ");
        soSachGiaoKhoa = scanner.nextInt();
        
        System.out.print("Nhập số sách tham khảo: ");
        soSachThamKhao = scanner.nextInt();
         
        System.out.println("Nhập thông tin sách giáo khoa:");
        for (int i = 0; i < soSachGiaoKhoa; i++) {
            System.out.println("Nhập thông tin quyển sách thứ " + (i + 1) + ":");
            
            sachgiaokhoa sachgiaokhoa = new sachgiaokhoa();
            
            sachgiaokhoa.nhapsach();
            
            arrsachgiaokhoa.add(sachgiaokhoa);
        }
         
        System.out.println("Nhập thông tin sách tham khảo:");
        for (int i = 0; i < soSachThamKhao; i++) {
            System.out.println("Nhập thông tin quyển sách thứ " + (i + 1) + ":");
            sachthamkhao sachthamkhao = new sachthamkhao();
            sachthamkhao.nhapsach();
            arrsachthamkhao.add(sachthamkhao);
        }
         
        for (int i = 0; i < arrsachgiaokhoa.size(); i++) {
            if (arrsachgiaokhoa.get(i).getSoLuong()== 0) {
                tongTienSachGiaoKhoa += arrsachgiaokhoa.get(i).getSoLuong() * 
                    arrsachgiaokhoa.get(i).getDonGia() * 50 / 100;
            } else if (arrsachgiaokhoa.get(i).getSoLuong() == 1) {
                tongTienSachGiaoKhoa += arrsachgiaokhoa.get(i).getSoLuong() * 
                    arrsachgiaokhoa.get(i).getDonGia();
            }
        }
        
        System.out.println("Tổng tiền sách giáo khoa = " + tongTienSachGiaoKhoa);
        
        
        System.out.println("-----Thông tin sách giáo khoa-----");
        for (int i = 0; i < arrsachgiaokhoa.size(); i++) {
            System.out.println(arrsachgiaokhoa.get(i).toString());
        }
         
        System.out.println("-----Thông tin sách tham khảo-----");
        for (int i = 0; i < arrsachthamkhao.size(); i++) {
            System.out.println(arrsachthamkhao.get(i).toString());
        }
         
        
        System.out.println("---Trung bình cộng đơn giá các sách tham khảo---");
        for (int i = 0; i < arrsachthamkhao.size(); i++) {
            tongDonGiaSachThamKhao += arrsachthamkhao.get(i).getDonGia();
            trungBinhCongDonGia = tongDonGiaSachThamKhao / arrsachthamkhao.size();
        }
        System.out.println("Trung bình cộng đơn giá các sách tham khảo = " + trungBinhCongDonGia);
         
        
        System.out.println("---Các sách giáo khoa của nhà xuất bản X---");
        for (int i = 0; i < arrsachgiaokhoa.size(); i++) {
            if (arrsachgiaokhoa.get(i).getNhaXuatBan().equalsIgnoreCase("X")){
                System.out.println(arrsachgiaokhoa.get(i).toString());
            }
        }
        
        
        for (int i = 0; i < arrsachthamkhao.size(); i++) {
            tongTienSachThamKhao += arrsachthamkhao.get(i).getSoLuong() * 
                arrsachthamkhao.get(i).getDonGia() + arrsachthamkhao.get(i).getThue();
        }
        System.out.println("Tổng tiền sách tham khảo = " + tongTienSachThamKhao);
    }
}

