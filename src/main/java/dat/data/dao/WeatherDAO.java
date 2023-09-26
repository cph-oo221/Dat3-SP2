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

    public Double getAvgTemp()
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(temperature) FROM Weather", Double.class)
                    .getSingleResult();
        }
    }

    public Double getAvgTempByCity(String city)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(temperature) FROM Weather WHERE city.name = :city", Double.class)
                    .setParameter("city", city)
                    .getSingleResult();
        }
    }


    public Double getAvgHumid()
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(humid) FROM Weather", Double.class)
                    .getSingleResult();
        }
    }

    public Double getAvgHumidByCity(String city)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(humid) FROM Weather WHERE city.name = :city", Double.class)
                    .setParameter("city", city)
                    .getSingleResult();
        }
    }

    public Double getAvgPrecip()
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(precipitation) FROM Weather", Double.class)
                    .getSingleResult();
        }
    }

    public Double getAvgPrecipByCity(String city)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(precipitation) FROM Weather WHERE city.name = :city", Double.class)
                    .setParameter("city", city)
                    .getSingleResult();
        }
    }

    public Double getAvgWind()
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(wind) FROM Weather", Double.class)
                    .getSingleResult();
        }
    }

    public Double getAvgWindByCity(String city)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT AVG(wind) FROM Weather WHERE city.name = :city", Double.class)
                    .setParameter("city", city)
                    .getSingleResult();
        }
    }
}