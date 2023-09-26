package dat.data.dao;

import dat.config.HibernateConfig;
import dat.model.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CityDAO implements IDAO<City>
{
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "update");

    private static CityDAO instance;

    public static CityDAO getInstance()
    {
        if (instance == null)
        {
            instance = new CityDAO();
        }
        return instance;
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

    public City readByName(String name)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT c FROM City c WHERE c.name = :name", City.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }
        catch (NoResultException e)
        {
            System.out.println("There is no city with that name in the database");
            System.out.println(e.getMessage());
            return null;
        }
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

    @Override
    public void create(City c)
    {
        try(EntityManager em = emf.createEntityManager())
        {

            City city = readByName(c.getName());

            if (city == null)
            {
                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
            }
            else
            {
                c.setId(city.getId());
                em.getTransaction().begin();
                em.merge(c);
                em.getTransaction().commit();
            }
        }
    }
}
