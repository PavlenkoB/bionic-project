package ua.ho.godex.dao;

import ua.ho.godex.domain.Category;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CategoryDao {
    List<Category> getAll();

    boolean delete(Category category);

    Category save(Category category);

    Category getById(Integer categoryId);
}
