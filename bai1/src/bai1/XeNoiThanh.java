/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.Scanner;

/**
 *
 * @author Kira
 */
public class XeNoiThanh extends ChuyenXe{
        private int sotuyen;
	private float sokm;
	XeNoiThanh() {
		super();
		this.sotuyen = sotuyen;
		this.sokm = sokm;
	}
	XeNoiThanh(int sotuyen, float sokm, String maso,String taixe,String soxe , long doanhthu) {
		super(maso,taixe,soxe,doanhthu);
		this.sotuyen = 0;
		this.sokm = 0;
	}

    public int getSotuyen() {
        return sotuyen;
    }

    public float getSokm() {
        return sokm;
    }

    public void setSotuyen(int sotuyen) {
        this.sotuyen = sotuyen;
    }

    public void setSokm(float sokm) {
        this.sokm = sokm;
    }
    
    public void Nhap(){
        super.Nhap();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập Số Tuyến: ");
            this.sotuyen= Integer.parseInt(sc.nextLine());

    }

    @Override
    public String toString() {
        return "XeNoiThanh" + super.toString() + ", sotuyen=" + sotuyen + ", sokm=" + sokm;
    }
    

}
