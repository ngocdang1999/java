/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_BP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NguyenNgocDang
 */
public class Cal extends UnicastRemoteObject implements intCal{
    public Cal() throws RemoteException{
        super();
    }
    

    public int tinhBP(int n) throws RemoteException {
        return n*n;
    }    
}
