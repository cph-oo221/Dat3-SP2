package dat.data.dao;

public interface IDao
{
    public void create(Object o);
    public Object read(Class c, int id);
    public void update(Object o);
    public void delete(Object o);
}
