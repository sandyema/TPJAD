package hello.Utils;

import hello.Domain.Contact;
import io.swagger.models.auth.In;

public interface IService extends Observable
{


    Iterable<Contact> getAll() throws Exception;
    Contact findContact(Integer idContact) throws Exception;

    @Override
    void NotifyObservers();

    @Override
    void RemoveObserver(Observer observer);

    @Override
    void AddObserver(Observer observer);
}
