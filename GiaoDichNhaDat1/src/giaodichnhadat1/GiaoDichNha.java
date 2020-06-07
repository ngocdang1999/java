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
public class GiaoDichNha extends GiaoDich {
    private String loaiNha, diaChi;
    private int choose;
     
    public GiaoDichNha() {
        super();
    }
 
    public GiaoDichNha(String loaiNha, String diaChi) {
        super();
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }
 
    public String getLoaiNha() {
        return loaiNha;
    }
 
    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }
 
    public String getDiaChi() {
        return diaChi;
    }
 
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
     
    public void nhap() {
        super.nhap();
        System.out.print("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();
        System.out.print("Nhập loại nhà (0: cao cấp, 1: thường): ");
        choose = scanner.nextInt();
        switch (choose) {
            case 0:
                loaiNha = "cao cấp";
                break;
            case 1: 
                loaiNha = "thường";
                break;
            default:
                System.out.println("Chọn số không hợp lệ.");
                break;
        }
    }
     
    @Override
    public String toString() {
        return super.toString() + ", loại nhà: " + this.loaiNha + ", địa chỉ: " + this.diaChi;
    }
}