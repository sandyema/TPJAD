package hello.Service;

import hello.Domain.Contact;
import hello.Repository.RepoHibernateContact;
import hello.Utils.IService;
import hello.Utils.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Service implements IService{
    private Map<String,Observer> notifyingMap;
    public List<Observer> observers;
    public RepoHibernateContact repoHibernateContact;

    public Service(RepoHibernateContact repoHibernateContact) {
        this.repoHibernateContact = repoHibernateContact;
        observers= new ArrayList<>();
        notifyingMap= new ConcurrentHashMap<>();


    }
    @Override
    public Iterable<Contact> getAll() throws Exception {
        return this.repoHibernateContact.findAll();
    }

    @Override
    public Contact findContact(Integer idContact) throws Exception {
        return this.repoHibernateContact.findOne(idContact);
    }

    @Override
    public void NotifyObservers() {
        try {
            Iterable<Contact> c = this.getAll();
            for (Observer o : observers)

                o.Notify(c);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void RemoveObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void AddObserver(Observer observer) {
        observers.add(observer);
    }

}
