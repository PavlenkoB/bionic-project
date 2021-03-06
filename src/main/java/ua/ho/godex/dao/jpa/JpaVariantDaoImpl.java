package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.VariantDao;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.Variant;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaVariantDaoImpl extends JpaGenericDaoImpl<Variant> implements VariantDao {
    public JpaVariantDaoImpl() {
        super(Variant.class);
    }

    @Override
    public List<Variant> getForAttribute(Integer attributeId) {
        return entityManager.find(Attribute.class, attributeId).getVariantList();
    }
}
