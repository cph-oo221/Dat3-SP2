package dat.data.dao;

public interface IDAO <T>
{
    public void create(T t);
    public T read(int id);
    public void update(T t);
    public void delete(T t);
}
