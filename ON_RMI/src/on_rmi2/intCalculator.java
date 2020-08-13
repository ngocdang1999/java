/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_rmi2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NguyenNgocDang
 */
public interface intCalculator extends Remote{

    public int tinhDoDai(String n) throws RemoteException;
}
