package dat.data.dao;

import dat.config.HibernateConfig;
import dat.model.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PrePersist;

public class CityDAO implements IDao<City>
{
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "update");

    private static CityDAO cityDAO = null;



    public static CityDAO getInstance()
    {
        if (cityDAO == null)
        {
            cityDAO = new CityDAO();
        }
        return cityDAO;
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
    public void update(City c)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(City c)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
    }

    public void create(City c)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            if (read(c.getId()) != null)
            {
                em.getTransaction().begin();
                update(c);
                em.getTransaction().commit();
            } else
            {
                em.getTransaction().begin();
                create(c);
                em.getTransaction().commit();
            }
        }
    }
}
