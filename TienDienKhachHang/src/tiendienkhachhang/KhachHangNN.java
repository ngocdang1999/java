/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendienkhachhang;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class KhachHangNN extends KhachHang{
    private String QuocTich;

    KhachHangNN() {
        super();
        this.QuocTich = QuocTich;
    }

    KhachHangNN(String QuocTich, String Makh, String Hoten, Date Ngay, float Sokw, float Dongia) {
        super();
        this.QuocTich = QuocTich;
    }

    public String getQuocTich() {
        return QuocTich;
    }

    public void setQuocTich(String QuocTich) {
        this.QuocTich = QuocTich;
    }
    
    Scanner scanner = new Scanner(System.in);

    @Override
    public void Nhap() throws Exception {
        super.Nhap(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Nhập quốc tịch: ");
        this.QuocTich = scanner.nextLine();

    }

    @Override
    public String toString() {
        return "KhachHangNN{" + super.toString() + "QuocTich=" + QuocTich + '}';
    }


    
    

}
