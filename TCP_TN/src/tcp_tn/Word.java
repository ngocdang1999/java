/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_tn;

/**
 *
 * @author NguyenNgocDang
 */
public class Word {
    private String vi;
    private String en;
    
    public Word() {
        
    }
    
    public Word (String en, String vi) {
        this.en = en;
        this.vi = vi;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s", en, vi);
    }

}
