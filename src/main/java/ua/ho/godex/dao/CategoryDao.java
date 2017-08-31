package ua.ho.godex.dao;

import ua.ho.godex.domain.Category;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    boolean delete(Category category);

    Category save(Category category);

    List<Category> getAll();

    Optional<Category> getById(Integer categoryId);
}
