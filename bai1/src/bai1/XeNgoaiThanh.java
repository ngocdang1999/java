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
public class XeNgoaiThanh extends ChuyenXe{
    private String noiden;
    private int songaydi;

    XeNgoaiThanh(){
        super();
        this.noiden = " ";
        this.songaydi = 0;
    }

    XeNgoaiThanh(String noiden, int songaydi) {
        super();
        this.noiden = noiden;
        this.songaydi = songaydi;
    }

    public void setNoiden(String noiden) {
        this.noiden = noiden;
    }

    public void setSongaydi(int songaydi) {
        this.songaydi = songaydi;
    }

    public String getNoiden() {
        return noiden;
    }

    public int getSongaydi() {
        return songaydi;
    }
    
    public void Nhap(){
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nơi Đến; ");
        this.noiden = sc.nextLine();
    }

    @Override
    public String toString() {
        return "XeNgoaiThanh" + super.toString() + ", noiden=" + noiden + ", songaydi=" + songaydi ;
    }
    

}

