/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuvien;

/**
 *
 * @author NguyenNgocDang
 */
public class sachthamkhao extends sach{
    private float thue;
    private int soLuong;
    private double thanhTien;

    public sachthamkhao() {
        super();
        this.thue = 0.0f;
        this.soLuong = 0;
        this.thanhTien = 0;
    }
        
    public sachthamkhao(float thue, int soLuong, double thanhTien) {
        super();
        this.thue = thue;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public float getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void nhapsach() {
        super.nhapsach();
        System.out.print("Nhập thuế: ");
        thue = scanner.nextFloat();
    }
     
    public String toString() {
        return super.toString() + ", Thuế: " + this.thue;
    }
}
