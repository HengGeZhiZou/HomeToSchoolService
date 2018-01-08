package priv.lyh.hts.dao;


import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findObjectById(Serializable id);

    List<T> findObjects();
}
