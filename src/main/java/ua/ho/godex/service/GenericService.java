package ua.ho.godex.service;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 06.09.2017
 * Project: supStore
 */
public interface GenericService<T> {
    List<T> getAll();

    T getById(Integer categoryId);

    T create(T category);

    void update(T category);

    boolean delete(Integer categoryId);
}
