package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.AttributeDao;
import ua.ho.godex.domain.Attribute;

import java.util.List;


@Repository
@Transactional
public class JpaAttributeDaoImpl extends JpaGenericDaoImpl<Attribute> implements AttributeDao {
    public JpaAttributeDaoImpl() {
        super(Attribute.class);
    }

    @Override
    public List<Attribute> getAll() {
        return entityManager.createQuery("SELECT O from Attribute O ORDER BY O.category.id", attributeClass).getResultList();
    }
}
