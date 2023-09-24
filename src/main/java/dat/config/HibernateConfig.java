package dat.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class HibernateConfig
{
    private static EntityManagerFactory entityManagerFactory;

    private static EntityManagerFactory buildEntityFactoryConfig(String dbName, String writeMethod)
    {
        try
        {
            Configuration configuration = new Configuration();

            Properties props = new Properties();
            String connctionURL = String.format("jdbc:postgresql://localhost:5432/"+ dbName +"?currentSchema=public");
            props.put("hibernate.connection.url", connctionURL);
            props.put("hibernate.connection.username", "postgres");
            props.put("hibernate.connection.password", "postgres");
            props.put("hibernate.show_sql", "true"); // show sql in console
            props.put("hibernate.format_sql", "true"); // format sql in console
            props.put("hibernate.use_sql_comments", "true"); // show sql comments in console

            props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); // dialect for postgresql
            props.put("hibernate.connection.driver_class", "org.postgresql.Driver"); // driver class for postgresql
            props.put("hibernate.archive.autodetection", "class"); // hibernate scans for annotated classes
            props.put("hibernate.current_session_context_class", "thread"); // hibernate current session context
            props.put("hibernate.hbm2ddl.auto", writeMethod); // hibernate creates tables based on entities


            return getEntityManagerFactory(configuration, props);
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static EntityManagerFactory getEntityManagerFactory(Configuration configuration, Properties props)
    {
        configuration.setProperties(props);

        getAnnotationConfiguration(configuration);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");

        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        return sf.unwrap(EntityManagerFactory.class);
    }

    private static void getAnnotationConfiguration(Configuration configuration)
    {
        List<Class<?>> classes = getClassesByPackage("dat.model");

        for (Class<?> aClass : classes)
        {
            if (aClass.isAnnotationPresent(jakarta.persistence.Entity.class))
            {
                configuration.addAnnotatedClass(aClass);
            }
        }
    }

    public static EntityManagerFactory getEntityManagerFactoryConfig(String dbName, String writeMethod)
    {
        if (entityManagerFactory == null) entityManagerFactory = buildEntityFactoryConfig(dbName, writeMethod);
        return entityManagerFactory;
    }

    private static List<Class<?>> getClassesByPackage(String packageName)
    {
        List<Class<?>> classResList = new ArrayList<>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL packageURL = classLoader.getResource(packagePath);

        if (packageURL != null)
        {
            try
            {
                File packageDir = new File(packageURL.toURI());

                if (packageDir.isDirectory())
                {
                    File[] files = packageDir.listFiles();

                    for (File file : files)
                    {
                        if (file.isFile() && file.getName().endsWith(".class"))
                        {
                            String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                            Class<?> clazz = classLoader.loadClass(className);
                            classResList.add(clazz);
                        }
                    }
                }
            }
            catch (URISyntaxException | ClassNotFoundException e)
            {
                throw new RuntimeException("Could not get classes from package " + packageName, e);
            }
        }
        return classResList;
    }
}