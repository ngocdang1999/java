/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlygiaodich;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class giaodichvang extends giaodich{
    private String LoaiVang;

    public giaodichvang() {
        super();
        this.LoaiVang = LoaiVang;
    }

    public giaodichvang(String LoaiVang, int MaGiaoDich, String NgayThang, float DonGia, float ThanhTien, int SoLuong) {
        super();
        this.LoaiVang = LoaiVang;
    }

    public String getLoaiVang() {
        return LoaiVang;
    }

    public void setLoaiVang(String LoaiVang) {
        this.LoaiVang = LoaiVang;
    }

    public void nhap (){
        super.nhap();
        System.out.println("Loại vàng: ");
        in.nextLine();
        LoaiVang = in.nextLine();
    }
    
    public double TTien(){
        return this.getDonGia()*this.getSoLuong();
    }
    
    public String toString(){
        return "Giao dich vang: " + super.toString() + ", Loai vang: " + LoaiVang + ", Thanh tien: " + TTien() + "]";
    }
}












