package by.mdhtrnk.pagegenerator.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> findAll();
    T save(T t);
    T findById(Long id);
    void deleteById(Long id);
}
