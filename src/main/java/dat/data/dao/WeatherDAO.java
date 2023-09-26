package dat.data.dao;

import dat.config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class WeatherDAO implements IDao
{
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "update");

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
    public WeatherDAO read(int id)
    {
        WeatherDAO foundObject;
        try(EntityManager em = emf.createEntityManager())
        {
            foundObject = em.find(WeatherDAO.class, id);
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
