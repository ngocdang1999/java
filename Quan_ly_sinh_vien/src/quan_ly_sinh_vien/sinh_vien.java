/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quan_ly_sinh_vien;

/**
 *
 * @author NguyenNgocDang
 */
public class sinh_vien {
    private int CodeSV;
    private String FullName;
    private float PointLT, PointTH, PointTB;
    public sinh_vien() {
    
}
    
    public void setCodeSV(int CodeSV){
        this.CodeSV = CodeSV;
    }
    
    public int getCodeSV(){
        return CodeSV;
    }
    
    public void setFullName(String FullName){
        this.FullName = FullName;
    }
    
    public String getFullName(){
        return FullName;
    }
    
    public void setPointLT(float PointLT){
        this.PointLT = PointLT;
    }
    
    public float getPointLT(){
        return PointLT;
    }
    
    public void setPointTH(float PointTH){
        this.PointTH = PointTH;
    }
    
    public float getPointTH(){
        return PointTH;
    }
    
    public float PointTB(){
        this.PointTB = (this.PointLT + this.PointTH)/2;
        return PointTB;
    }
    
    public void View(){
        System.out.println("CodeSV: " + CodeSV);
        System.out.println("Fullname: " + FullName);
        System.out.println("PointTB: " + PointTB);
    }
    
    public sinh_vien(int CodeSV, String FullName, float PointLT, float PointTH){
        this.CodeSV = CodeSV;
        this.FullName = FullName;
        this.PointLT = PointLT;
        this.PointTH = PointTH;
    }
    
}
