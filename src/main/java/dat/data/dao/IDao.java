package dat.data.dao;

public interface IDao
{
    public void create(Object o);
    public Object read(int id);
    public void update(Object o);
    public void delete(Object o);
}
