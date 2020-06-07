/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Kira
 */
public class ChuyenXe implements Serializable{
    private String maso;
    private String taixe;
    private String soxe;
    private long doanhthu;
    
    	public ChuyenXe(String maso, String taixe, String soxe, long doanhthu) {
		this.maso = maso;
		this.taixe = taixe;
		this.soxe = soxe;
		this.doanhthu = doanhthu;
	}
	
	public ChuyenXe() {
		this.maso = " ";
		this.taixe = " ";
		this.soxe = " ";
		this.doanhthu = 0;
	}
	public String getMaso() {
		return maso;
	}
	public void setMaso(String maso) {
		this.maso = maso;
	}
	public String getTaixe() {
		return taixe;
	}
	public void setTaixe(String taixe) {
		this.taixe = taixe;
	}
	public String getSoxe() {
		return soxe;
	}
	public void setSoxe(String soxe) {
		this.soxe = soxe;
	}
	public long getDoanhthu() {
		return doanhthu;
	}
	public void setDoanhthu(long doanhthu) {
		this.doanhthu = doanhthu;
	}
        public void Nhap(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập Mã Số Xe: ");
            this.maso= sc.nextLine();
            System.out.println("Nhập Tên Tài Xế: ");
            this.taixe= sc.nextLine();
            System.out.println("Nhập Số Xe: ");
            this.soxe= sc.nextLine();
        }

    @Override
    public String toString() {
        return "maso=" + maso + ", taixe=" + taixe + ", soxe=" + soxe + ", doanhthu=" + doanhthu ;
    }
        
}
