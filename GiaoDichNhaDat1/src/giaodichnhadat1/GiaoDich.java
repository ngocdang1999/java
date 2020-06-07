/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodichnhadat1;

/**
 *
 * @author Kira
 */
import java.util.Scanner;
 
public class GiaoDich {
    private String maGiaoDich, ngayGiaoDich;
    private long donGia;
    private float dienTich;
    Scanner scanner = new Scanner(System.in);
     
    public GiaoDich() {
        super();
    }
 
    public GiaoDich(String maGiaoDich, String ngayGiaoDich, long donGia, float dienTich) {
        super();
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }
 
    public String getMaGiaoDich() {
        return maGiaoDich;
    }
 
    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }
 
    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }
 
    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }
 
    public long getDonGia() {
        return donGia;
    }
 
    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }
 
    public float getDienTich() {
        return dienTich;
    }
 
    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }
     
    public void nhap() {
        System.out.print("Nhập mã giao dịch: ");
        maGiaoDich = scanner.nextLine();
        System.out.print("Nhập ngày giao dịch (ngày/tháng/năm): ");
        ngayGiaoDich = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = Long.parseLong(scanner.nextLine());
        System.out.print("Nhập diện tích: ");
        dienTich = Float.parseFloat(scanner.nextLine());
    }
     
    @Override
    public String toString() {
        return "Mã giao dịch: " + this.maGiaoDich + ", ngày giao dịch: " + this.ngayGiaoDich + 
            ", đơn giá: " + this.donGia + ", diện tích: " + this.dienTich;
    }
}

