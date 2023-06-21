package Utils;

import Entity.Client;
import Entity.Planet;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Data
public class HibernateUtil {
    private static final HibernateUtil INSTANCE;
    static {
        INSTANCE = new HibernateUtil();
    }
    private final SessionFactory sessionFactory;

    public HibernateUtil () {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
