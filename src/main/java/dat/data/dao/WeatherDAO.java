package dat.data.dao;

import dat.config.HibernateConfig;
import dat.model.Weather;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class WeatherDAO implements IDao
{
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "create");

    private static WeatherDAO weatherDAO = null;

    public WeatherDAO getInstance()
    {
        if (weatherDAO == null)
        {
            weatherDAO = new WeatherDAO();
        }
        return weatherDAO;
    }
    @Override
    public void create(Object o)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }
    }

    @Override
    public Object read(Class c, int id)
    {
        Object foundObject;
        try(EntityManager em = emf.createEntityManager())
        {
            foundObject = em.find(c, id);
        }
        return foundObject;
    }

    @Override
    public void update(Object o)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        }
    }
    @Override
    public void delete(Object o)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        }
    }
}
