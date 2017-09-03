package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.AttributeDao;
import ua.ho.godex.domain.Attribute;


@Repository
@Transactional
public class JpaAttributeDaoImpl extends JpaGenericDaoImpl<Attribute> implements AttributeDao {
    public JpaAttributeDaoImpl() {
        super(Attribute.class);
    }
}
