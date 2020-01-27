package hello.Utils;

import hello.Domain.Contact;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {
    void Notify(Iterable<Contact> participants)throws RemoteException;
}