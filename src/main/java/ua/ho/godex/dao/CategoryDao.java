package ua.ho.godex.dao;

import ua.ho.godex.domain.Category;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    List<Category> getAll();

    boolean delete(Category category);

    Category save(Category category);

    Optional<Category> getById(Integer categoryId);
}
