/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Kira
 */
public class CD {
    private int MaCD;
    private String TuaCD;
    private String CaSy;
    private int SoBaiHat;
    private double GiaThanh;
    private CD CDK[] = new CD[100];

    public CD() {
    }

    public CD(int MaCD, String TuaCD, String CaSy, int SoBaiHat, double GiaThanh) {
        this.MaCD = MaCD;
        this.TuaCD = TuaCD;
        this.CaSy = CaSy;
        this.SoBaiHat = SoBaiHat;
        this.GiaThanh = GiaThanh;
    }

    

    public String getCaSy() {
        return CaSy;
    }

    public void setCaSy(String CaSy) {
        this.CaSy = CaSy;
    }
    
    
    public int getMaCD() {
        return MaCD;
    }

    public void setMaCD(int MaCD) {
        this.MaCD = MaCD;
    }

    public String getTuaCD() {
        return TuaCD;
    }

    public void setTuaCD(String TuaCD) {
        this.TuaCD = TuaCD;
    }

    public int getSoBaiHat() {
        return SoBaiHat;
    }

    public void setSoBaiHat(int SoBaiHat) {
        this.SoBaiHat = SoBaiHat;
    }

    public double getGiaThanh() {
        return GiaThanh;
    }

    public void setGiaThanh(double GiaThanh) {
        this.GiaThanh = GiaThanh;
    }

    @Override
    public String toString() {
        return String.format("{MaCD: %d TuaCD: %s Casy: %s SoBaiHat: %d GiaThanh: %f}",MaCD,TuaCD,CaSy,SoBaiHat,GiaThanh);
  
    }
    
    public void ShowInfo(){
            System.out.println("Ma CD La:" + getMaCD());
            System.out.println("Tua CD La: " + getTuaCD());
            System.out.println("Ca Sy La: "+ getCaSy());
            System.out.println("So Bai Hat La: "+ getSoBaiHat());
            System.out.println("Gia Thanh La:  " + getGiaThanh());
    }
    public void CheckID(int n){
        for(int i=n;i>0;i--){
            int h = CDK[n].getMaCD();
            if( h == CDK[n].getMaCD()){
                System.out.println("ID ban Nhap Sai");
        }
    }
}
}
