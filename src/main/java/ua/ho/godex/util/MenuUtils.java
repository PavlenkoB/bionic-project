package ua.ho.godex.util;

import ua.ho.godex.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Creator: Pavlenko Bohdan
 * Date: 10.09.2017
 * Project: supStore
 */
public class MenuUtils {
    public static List<Category> createHierarchic(List<Category> categoryList) {
        Map<Integer, Category> integerCategoryHashMap = categoryList.stream().collect(Collectors.toMap(Category::getId, Category::getSelf));
        for (Category category : categoryList) {
            Integer parentCatId = category.getParentCatId();
            if (parentCatId != null) {
                integerCategoryHashMap.get(parentCatId).getChildren().add(category);
            }
        }
        List<Category> categories = new ArrayList<>();
        for (Category category : categoryList) {
            Integer parentCatId = category.getParentCatId();
            if (parentCatId == null) {
                categories.add(category);
            }
        }
        return categories;
    }
}
