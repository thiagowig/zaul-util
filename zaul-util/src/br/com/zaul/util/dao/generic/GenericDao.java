package br.com.zaul.util.dao.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, PK extends Serializable> {

    Object create(T object);

    void update(T object);

    void delete(PK id);

    T findByPK(PK id);

    List<T> findAll();

    List<T> findByExample(T object);

}