/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_5_ltm;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NguyenNgocDang
 */
public class message implements Serializable{
    public static final int XEM_DANH_SACH = 1;
	public static final int THEM_SINH_VIEN = 2;
	
	private int chon;//SỰ LỰA CHỌN CỦA NGƯỜI DÙNG
	
	private List<SinhVien> dsSV;
    
	public int getChon() {
		return chon;
	}

	public void setChon(int chon) {
		this.chon = chon;
	}

	public List<SinhVien> getDsSV() {
		return dsSV;
	}

	public void setDsSV(List<SinhVien> dsSV) {
		this.dsSV = dsSV;
	}
	
}
