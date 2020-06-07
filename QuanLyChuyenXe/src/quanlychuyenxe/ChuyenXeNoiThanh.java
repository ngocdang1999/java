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
public class ChuyenXeNoiThanh extends ChuyenXe{
    private int SoTuyen;
    private float SoKM;

    ChuyenXeNoiThanh() {
        super();
        this.SoTuyen = 0;
        this.SoKM = 0.0f;
    }

    public ChuyenXeNoiThanh(int SoTuyen, float SoKM, String MSChuyen, String HoTen, String SoXe, float DoanhThu) {
        super();
        this.SoTuyen = SoTuyen;
        this.SoKM = SoKM;
    }

    public int getSoTuyen() {
        return SoTuyen;
    }

    public void setSoTuyen(int SoTuyen) {
        this.SoTuyen = SoTuyen;
    }

    public float getSoKM() {
        return SoKM;
    }

    public void setSoKM(float SoKM) {
        this.SoKM = SoKM;
    }

    Scanner scanner = new Scanner(System.in);
    
    public void Nhap(){
        super.Nhap();
        System.out.print("Nhap so tuyen:");
        this.SoTuyen = scanner.nextInt();
        System.out.print("Nhap so ki lo met:");
        this.SoKM = scanner.nextFloat();
    }

    @Override
    public String toString() {
        return "ChuyenXeNoiThanh{" + super.toString() + "SoTuyen=" + SoTuyen + ", SoKM=" + SoKM ;
    }
    
    
}
