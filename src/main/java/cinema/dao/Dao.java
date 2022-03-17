package cinema.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    void delete(Long id);

    void update(T entity);

    void save(T entity);
}