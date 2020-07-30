/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_anhviet;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Sample extends UnicastRemoteObject implements IMyRemote {

    ArrayList<Word> ListWord;

    public Sample(ArrayList<Word> list) throws RemoteException {
        super();
        ListWord = list;
    }

    @Override
    public String English_to_Vietnamese(String s) throws RemoteException {
        for (Word word : ListWord) {
            if (word.English.equals(s)) {
                return word.Vietnamese;
            }
        }
        return "Khong tim thay!";
    }

    @Override
    public String Vietnamese_to_English(String s) throws RemoteException {
        for (Word word : ListWord) {
            if (word.Vietnamese.equals(s)) {
                return word.English;
            }
        }
        return "Khong tim thay!";
    }

    @Override
    public String translate(String s) throws RemoteException {
        for (Word word : ListWord) {
            if (word.English.equals(s)) {
                return word.Meaning;
            }
        }
        return "Khong tim thay!";
    }

}
