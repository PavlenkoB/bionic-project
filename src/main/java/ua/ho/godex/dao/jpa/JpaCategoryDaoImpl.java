package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.CategoryDao;
import ua.ho.godex.domain.Category;

import java.util.List;

@Repository
@Transactional
public class JpaCategoryDaoImpl extends JpaGenericDaoImpl<Category> implements CategoryDao {
    public JpaCategoryDaoImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> getAll() {
        return entityManager.createQuery("SELECT O from Category O ORDER BY O.order asc ", Category.class).getResultList();
    }
}
