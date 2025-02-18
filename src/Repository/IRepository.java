package Repository;

import java.util.List;

public interface IRepository<T, I> {
    void add(T item);
    void remove(T item);
    List<T> getAll();
    T findByIdentifier(I identifier);
    void update(T item);
}