/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlygiaodich;

/**
 *
 * @author NguyenNgocDang
 */
public class list {
    giaodich gd[] = new giaodich[100];
	private int CountGD, sum1=0, sum2=0, dem=0, sumtien=0;
	public list()
	{
		CountGD=0;
		for(int i=0; i<100; i++)
			gd[i] = new giaodich(); 
	}
	public void ThemGD(int temp)
	{
		if(CountGD>100)
			System.out.println("Bo nho full, ko the them moi!");
		else
		{
			if(temp==1)
			{
				gd[CountGD] = new giaodichvang();
				giaodichvang gdv = new giaodichvang();
				gdv.nhap();
				gdv.TTien();
				gd[CountGD] = gdv;
				sum1+=gdv.getSoLuong();
			}
			else
			{
				gd[CountGD] = new giaodichtien();
				giaodichtien gdtt = new giaodichtien();
				gdtt.nhap();
				gdtt.TTien();
				gd[CountGD] = gdtt;
				sumtien+=gdtt.TTien();
				sum2+=gdtt.getSoLuong();
				dem++;
			}
			CountGD++;
		}
	}
	public void HienThiDS()
	{
		for(int i=0; i<CountGD; i++)
		{
			System.out.println("\n----So TT: " + (i+1));
			System.out.println(gd[i].toString());
		}
	}
	// Tong so luong cua giao dich
	public void TongSL()
	{
		System.out.println("|->  Tong So Luong cua Giao Dich Vang: " + sum1 + "  <-|");
		System.out.println("|->  Tong So Luong cua Giao Dich Tien Te:" + sum2 + "  <-|");
	}
	
	public void TrungBinhGDTT()
	{
		System.out.println("|->  Trung Binh Thanh Tien Giao Dich Tien Te: " 
					+ (sumtien/dem) + "  <-|");
	}
	// xuat danh sach giao dich 1 ty
	public void GiaoDich1ty()
	{
		int d=0;
		for(int i=0; i<CountGD; i++)
		{
			if(gd[i].getDonGia()>1000)
			{
				System.out.println(gd[i].toString());
				d++;
			}
		}
		if(d==0)
			System.out.println("Khong co Thong Tin!");
	}
}
