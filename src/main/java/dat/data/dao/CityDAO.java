package dat.data.dao;

import dat.config.HibernateConfig;
import dat.model.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CityDAO implements IDao
{
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "create");

    private static CityDAO cityDAO = null;

    public CityDAO getInstance()
    {
        if (cityDAO == null)
        {
            cityDAO = new CityDAO();
        }
        return cityDAO;
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
    public City read(int id)
    {
        City foundObject;
        try(EntityManager em = emf.createEntityManager())
        {
            foundObject = em.find(City.class, id);
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
