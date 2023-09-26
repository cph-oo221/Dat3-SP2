package dat.data.dao;

import dat.config.HibernateConfig;
import dat.model.Weather;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class WeatherDAO implements IDao<Weather>
{
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "update");

    private static WeatherDAO weatherDAO = null;

    public static WeatherDAO getInstance()
    {
        if (weatherDAO == null)
        {
            weatherDAO = new WeatherDAO();
        }
        return weatherDAO;
    }
    @Override
    public void create(Weather w)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(w);
            em.getTransaction().commit();
        }
    }

    @Override
    public Weather read(int id)
    {
        Weather foundObject;
        try(EntityManager em = emf.createEntityManager())
        {
            foundObject = em.find(Weather.class, id);
        }
        return foundObject;
    }

    @Override
    public void update(Weather w)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.merge(w);
            em.getTransaction().commit();
        }
    }
    @Override
    public void delete(Weather w)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.remove(w);
            em.getTransaction().commit();
        }
    }
}
