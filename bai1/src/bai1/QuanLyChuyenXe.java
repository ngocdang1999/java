/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kira
 */
public class QuanLyChuyenXe {
    ArrayList<ChuyenXe> listxe;

QuanLyChuyenXe() {
    listxe = new ArrayList<>();
    }
public void NhapChuyenXe(){
    Scanner sc = new Scanner(System.in);
    String traloi = null;
    do {
    System.out.print("Chon xe (1: Noi thanh, 2: Ngoai thanh):");
    int Chon= Integer.parseInt(sc.nextLine());
    switch(Chon){
        case 1:{
            XeNoiThanh xenoi = new XeNoiThanh();
            xenoi.Nhap();
            listxe.add(xenoi);
            break;
        }
        case 2:{
            XeNgoaiThanh xengoai= new XeNgoaiThanh();
            xengoai.Nhap();
            listxe.add(xengoai);
            break;
        }
    }
        System.out.print("Ban co muon nhap tiep hay khong?");
        traloi=sc.nextLine();  
    }while(traloi.equals("t"));
}
public void XuatChuyenXe(){
    for(ChuyenXe xe:listxe)
        System.out.println(xe.toString());
}

private boolean capNhatDanhThu(String maso, long doanhthu){
    for (ChuyenXe xe:listxe){
        if(xe.getMaso().equals(maso)){
            xe.setDoanhthu(xe.getDoanhthu()+doanhthu);
            return true;
        }
    }
    return false;
}

public void nhapDoanhThu(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap doanh thu:");
    System.out.print("\nMa so xe:");
    String maso = sc.nextLine();
    System.out.print("\nDoanh thu:");
    long doanhthu = Long.parseLong(sc.nextLine());
    if(this.capNhatDanhThu(maso, doanhthu))
        System.out.println("Nhap doanh thu dung");
    else
        System.out.println("Nhap doanh thu sai");
}   

public void thongKeDoanhThu(){
    long dt_noi=0, dt_ngoai=0;
    for(ChuyenXe xe:listxe)
        if(xe instanceof XeNoiThanh)
            dt_noi +=xe.getDoanhthu();
        else
            dt_ngoai +=xe.getDoanhthu();
    System.out.println("Tông doanh thu ");
    System.out.println("Xe nội:" + dt_noi);
    System.out.println("Xe ngoại:" + dt_ngoai);
}

public void thongKeLoaiXe(){
    
}
}
