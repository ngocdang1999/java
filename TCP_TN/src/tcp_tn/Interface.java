/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_tn;

import java.rmi.Remote;

/**
 *
 * @author NguyenNgocDang
 */
public interface Interface extends Remote{
    
    public String viToEn(String vi) throws Exception;
    public String enToVi(String en) throws Exception;
    
}
