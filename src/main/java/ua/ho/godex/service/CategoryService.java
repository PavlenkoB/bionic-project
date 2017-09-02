package ua.ho.godex.service;

import ua.ho.godex.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getById(Integer categoryId);

    Category create(Category category);

    void update(Category category);

    boolean delete(Integer categoryId);
}
