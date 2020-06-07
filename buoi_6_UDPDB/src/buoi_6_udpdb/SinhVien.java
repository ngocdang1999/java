package buoi_6_udpdb;

import java.io.Serializable;
import java.util.Date;

//CLASS NÀY DÙNG ĐỂ TRUYỀN TRONG MÔI TRƯỜNG MẠNG
//CHO NÊN PHẢI IMPLEMENTS SERIAL....
public class SinhVien implements Serializable {

	private int mssv;
	private String tenSV;
	private Date ngaysinh;
	private String quequan;

	// PHẢI CÓ SET/GET CHO MỖI THUỘC TÍNH
	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	// HÀM TẠO
	// HÀM TẠO RỖNG
	public SinhVien() {
	}

	// HÀM TẠO CÓ THAM SỐ
	public SinhVien(int mssv, String tenSV, Date ngaysinh, String quequan) {
		this.mssv = mssv;
		this.tenSV = tenSV;
		this.ngaysinh = ngaysinh;
		this.quequan = quequan;
	}

	@Override
	public String toString() {
		return "SinhVien [mssv=" + mssv + ", tenSV=" + tenSV + ", ngaysinh=" + ngaysinh + ", quequan=" + quequan + "]";
	}

	// THÔNG TIN CỦA SINH VIÊN

}
