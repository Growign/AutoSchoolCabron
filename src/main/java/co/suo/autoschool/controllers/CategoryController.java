package co.suo.autoschool.controllers;

import co.suo.autoschool.dto.CategoryDto;
import co.suo.autoschool.model.Category;
import co.suo.autoschool.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {this.categoryService = categoryService;}

    @GetMapping
    public ResponseEntity<Page<CategoryDto>> getAllCategory(@PageableDefault Pageable pageable){
        Page<CategoryDto> category = categoryService.getAllCategories(pageable);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        CategoryDto category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody Category category){
        categoryService.saveCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody Category category, @PathVariable Long id){
        categoryService.updateCategoryData(category, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
