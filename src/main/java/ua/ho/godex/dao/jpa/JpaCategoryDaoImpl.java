package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.CategoryDao;
import ua.ho.godex.domain.Category;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaCategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> getAll() {
        return null;
        //todo write
    }

    @Override
    public boolean delete(Category category) {
        return false;
        //todo write
    }

    @Override
    public Category save(Category category) {
        return null;
        //todo write
    }

    @Override
    public Optional<Category> getById(Integer categoryId) {
        return null;
        //todo write
    }
}
