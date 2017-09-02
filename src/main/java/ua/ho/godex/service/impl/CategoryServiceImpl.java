package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.CategoryDao;
import ua.ho.godex.domain.Category;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.util.exception.NotFoundException;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category getById(Integer categoryId) {
        return categoryDao.getById(categoryId).
                orElseThrow(() -> new NotFoundException(String.format("Category с id=%d не найден", categoryId)));
    }

    @Override
    public Category create(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.save(category);
    }

    @Override
    public boolean delete(Integer categoryId) {
        return categoryDao.delete(categoryId);
    }
}
