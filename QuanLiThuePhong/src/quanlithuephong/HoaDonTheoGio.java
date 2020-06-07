/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlithuephong;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Kira
 */
public class HoaDonTheoGio extends HoaDon{
    private int SoGioThue;

    public HoaDonTheoGio() {
        super();
        this.SoGioThue = 0;
    }

    public HoaDonTheoGio(int SoGioThue, String MaHoaDon, Date NgayHoaDon, String TenKhachHang, String MaPhong, float DonGia) {
        super(MaHoaDon, NgayHoaDon, TenKhachHang, MaPhong, DonGia);
        this.SoGioThue = SoGioThue;
    }
    
    
    public int getSoGioThue() {
        return SoGioThue;
    }

    public void setSoGioThue(int SoGioThue) {
        this.SoGioThue = SoGioThue;
    }
    
    @Override
    public void Nhap() throws Exception {
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Số Giờ Thuê :");
        this.SoGioThue = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        if(this.TinhThanhTien()!=0)
        return "HoaDonTheoGio{" + super.toString()+ "SoGioThue=" + SoGioThue + "Thanh Tien" + this.TinhThanhTien()+ '}';
        else return "Số Giờ Bạn Không Được Tính Theo Quá Đơn Giờ";
    }
    
    public double TinhThanhTien(){
        
        if(this.getSoGioThue()< 24) 
            return this.getSoGioThue()*super.getDonGia();
        else if(this.getSoGioThue()> 24 && this.getSoGioThue() < 30 )
            return this.getDonGia()*24;
        else return 0; 
             
    }

}
