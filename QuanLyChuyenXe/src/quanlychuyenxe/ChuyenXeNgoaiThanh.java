/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenxe;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class ChuyenXeNgoaiThanh extends ChuyenXe{
    private String NoiDen;
    private int NgayDD;

    ChuyenXeNgoaiThanh() {
        super();
        this.NoiDen = " ";
        this.NgayDD = 0;
    }

    public ChuyenXeNgoaiThanh(String NoiDen, int NgayDD, String MSChuyen, String HoTen, String SoXe, float DoanhThu) {
        super();
        this.NoiDen = NoiDen;
        this.NgayDD = NgayDD;
    }

    public String getNoiDen() {
        return NoiDen;
    }

    public void setNoiDen(String NoiDen) {
        this.NoiDen = NoiDen;
    }

    public int getNgayDD() {
        return NgayDD;
    }

    public void setNgayDD(int NgayDD) {
        this.NgayDD = NgayDD;
    }

    Scanner scanner =  new Scanner(System.in);
    
    public void Nhap(){
        super.Nhap();
        System.out.print("Nhap noi den:");
        this.NoiDen = scaner.nextLine();
        System.out.print("Nhap ngay di duoc:");
        this.NgayDD = scaner.nextInt();
     
    }

    @Override
    public String toString() {
        return "ChuyenXeNgoaiThanh" + super.toString() + "NoiDen=" + NoiDen + ", NgayDD=" + NgayDD;
    }
    
    
    
}
