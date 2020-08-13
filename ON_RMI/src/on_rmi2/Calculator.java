/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_rmi2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NguyenNgocDang
 */
public class Calculator extends UnicastRemoteObject implements intCalculator{
    public Calculator() throws RemoteException{
        super();
    }
    

    public int tinhDoDai(String n) throws RemoteException {
        return n.length();
    }    
}
