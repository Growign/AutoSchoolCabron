package co.suo.autoschool.services;

import co.suo.autoschool.dto.CategoryDto;
import co.suo.autoschool.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

@Service
public interface CategoryService {

    CategoryDto saveCategory(Category category);

    Page<CategoryDto> getAllCategories(Pageable pageable);

    CategoryDto getCategoryById(Long id);

    CategoryDto updateCategoryData(Category category, Long id);

    void deleteCategoryById(Long id);

}
