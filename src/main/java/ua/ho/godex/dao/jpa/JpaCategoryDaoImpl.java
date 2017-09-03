package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.CategoryDao;
import ua.ho.godex.domain.Category;

@Repository
@Transactional
public class JpaCategoryDaoImpl extends JpaGenericDaoImpl<Category> implements CategoryDao {
    public JpaCategoryDaoImpl() {
        super(Category.class);
    }
}
