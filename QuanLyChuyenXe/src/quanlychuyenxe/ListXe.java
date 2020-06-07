/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenxe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class ListXe {
    ArrayList<ChuyenXe> listxe;

    ListXe() {
        listxe = new ArrayList<>();
    }
    
    public void NhapChuyenXe(){
        String traloi;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Chọn loại xe: <1. Nội Thành VÀ <2. Ngoại Thành");
            int Chon = Integer.parseInt(scanner.nextLine());
            switch (Chon){
                case 1: ChuyenXeNoiThanh cxnt= new ChuyenXeNoiThanh();
                cxnt.Nhap();
                if(!listxe.contains(cxnt)){
                    listxe.add(cxnt);
                    System.out.print("Đã thêm thành công");
                }
                else
                    System.out.print("Trùng mã số");
                break;
                case 2: ChuyenXeNgoaiThanh xnt = new ChuyenXeNgoaiThanh();
                xnt.Nhap();
                if(!listxe.contains(xnt)){
                    listxe.add(xnt);
                    System.out.print("Đã thêm thành công");
                }
                else
                    System.out.print("Trùng mã số");
            }
            System.out.print("Ban co nhap tiep hay khong: <t/k> ");
            traloi = scanner.nextLine();
        }while(traloi.equals("t"));
    }
    
    public void XuatChuyenXe(){
        for(ChuyenXe cx:listxe)
            System.out.println(cx.toString());
    }
    
    
}
