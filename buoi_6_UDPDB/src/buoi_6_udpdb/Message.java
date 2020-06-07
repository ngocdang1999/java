package buoi_6_udpdb;

import java.io.Serializable;
import java.util.List;

//LỚP NÀY ĐỂ CHỨA CÁC THÔNG TIN TRUYỀN/NHẬN GIỮA CLIENT/SERVER
public class Message implements Serializable {
	
	public static final int XEM_DANH_SACH = 1;
	public static final int THEM_SINH_VIEN = 2;
	
	private int chon;//SỰ LỰA CHỌN CỦA NGƯỜI DÙNG
	
	private List<SinhVien> dsSV;
	
	private SinhVien sinhvienAdd;
	
	
	

	public SinhVien getSinhvienAdd() {
		return sinhvienAdd;
	}

	public void setSinhvienAdd(SinhVien sinhvienAdd) {
		this.sinhvienAdd = sinhvienAdd;
	}

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

    SinhVien setSinhvienAdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
	
	
	

}
