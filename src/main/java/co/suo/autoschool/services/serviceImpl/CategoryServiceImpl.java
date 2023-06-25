package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.CategoryDto;
import co.suo.autoschool.dto.creatingdto.CarCreatingDto;
import co.suo.autoschool.mapper.CategoryMapper;
import co.suo.autoschool.model.CarModel;
import co.suo.autoschool.model.Category;
import co.suo.autoschool.repositoryInterface.CategoryRepository;
import co.suo.autoschool.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryDto saveCategory(Category category) {
        return categoryMapper.categoryToCategoryDto(categoryRepository.save(category));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CategoryDto> getAllCategories(Pageable pageable) {
        log.info("Getting all category");
        return categoryRepository.findAll(pageable).map(categoryMapper::categoryToCategoryDto);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDto getCategoryById(Long id) {
        return categoryMapper.categoryToCategoryDto(categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Category not found by id: "+ id)));
    }

    @Override
    @Transactional
    public CategoryDto updateCategoryData(Category category, Long id) {
        Optional<Category> tempCategory = categoryRepository.findById(id);

        if (tempCategory.isPresent()) {
            Category presentCategory = tempCategory.get();
            setAllFieldsForCategory(category, presentCategory);

            return categoryMapper.categoryToCategoryDto(categoryRepository.save(presentCategory));
        } else {
            throw new NoSuchElementException();
        }

    }

    @Override
    @Transactional
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    private void setAllFieldsForCategory(Category category, Category categoryForUpdate) {
        if (category == null) {
            return;
        }

        if (category.getCategory() != null) {
            categoryForUpdate.setCategory(category.getCategory());
        }
    }
}
