package Services;

import Entity.Client;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientCrudService {
    public void create(String name) {
        Client client = new Client();
        client.setName(name);

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public String getById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client foundClient = session.get(Client.class, id);
            return foundClient.getName();
        }
    }

    public void updateById(int id, String name) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            client.setName(name);
            session.merge(client);
            transaction.commit();
        }
    }

    public void deleteById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            transaction.commit();
        }
    }
}