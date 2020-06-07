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
public class GiaoDichDat extends GiaoDich {
    private String loaiDat;
 
    public GiaoDichDat() {
        super();
    }
 
    public GiaoDichDat(String loaiDat) {
        super();
        this.loaiDat = loaiDat;
    }
 
    public String getLoaiDat() {
        return loaiDat;
    }
 
    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }
     
    public void nhap() {
        super.nhap();
        System.out.print("Nhập loại đất (A/B/C): ");
        loaiDat = scanner.nextLine();
    }
 
    @Override
    public String toString() {
        return super.toString() + ", loại đất: " + this.loaiDat;
    }
}
