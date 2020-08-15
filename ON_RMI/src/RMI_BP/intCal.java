/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_BP;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NguyenNgocDang
 */
public interface intCal extends Remote{
    public int tinhBP(int n) throws RemoteException;
}
