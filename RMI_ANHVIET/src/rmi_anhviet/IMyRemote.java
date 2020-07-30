/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_anhviet;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface IMyRemote extends Remote {

    public String English_to_Vietnamese(String s) throws RemoteException;

    public String Vietnamese_to_English(String s) throws RemoteException;

    public String translate(String s) throws RemoteException;
}
