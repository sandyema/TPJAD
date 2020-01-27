package hello.Repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface IRepository<ID, T> {
    void save(T entity) throws Exception;
    T findOne(ID id) throws Exception;
    Iterable<T> findAll() throws Exception;
}