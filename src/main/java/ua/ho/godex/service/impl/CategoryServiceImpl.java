package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.CategoryDao;
import ua.ho.godex.domain.Category;
import ua.ho.godex.service.CategoryService;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {
    @Autowired
    public CategoryServiceImpl(CategoryDao genericDao) {
        super(Category.class, genericDao);
    }
}
