package hello.Repository;
import hello.Domain.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RepoHibernateContact implements IRepoContact {
    private SessionFactory sessionFactory;

    public RepoHibernateContact(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public RepoHibernateContact()
    {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();

    }
    @Override
    public void save(Contact entity) throws Exception {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession())
        {
            transaction=session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction!=null)
                transaction.rollback();
            throw  e;
        }
    }

    @Override
    public Contact findOne(Integer integer) throws Exception {
        Contact c;
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession())
        {
            transaction=session.beginTransaction();
            c=session.get(Contact.class,integer);
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction!=null)
                transaction.rollback();
            throw  e;
        }
        return  c;    }

    @Override
    public Iterable<Contact> findAll() throws Exception {
        //Transaction transaction = null;
        Iterable<Contact> participanti = null;
        try(Session session= sessionFactory.openSession())
        {
            //  transaction= session.beginTransaction();

            participanti= session.createQuery("from Contact ").list();
            // transaction.commit();
        }
        catch (Exception e)
        {
            // if(transaction!=null)
            //   transaction.rollback();
            throw new Exception(e);
        }
        return participanti;
    }

}
