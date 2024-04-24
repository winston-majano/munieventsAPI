package com.munievents.munievents.controller;

import com.munievents.munievents.entity.Category;
import com.munievents.munievents.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    //TODO: obtenemos todas las categorias
    @GetMapping("/category")
    public List<Category> getAll() {
        return categoryService.getCategories();
    }

    @GetMapping("/category/{idCategory}")
    public Optional<Category> getById(@PathVariable("idCategory") Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }


    //TODO: enviamos el body una nueva categoria
    @PostMapping("/category")
    public String saveCategory(@RequestBody Category category) {
        categoryService.saveOrUpdate(category);
        return "Categoria creada correctamente";
    }

    //TODO: ResposeEntity<Category>   y retorno una nueva ResponseEntity<>(_objeto, HttpStatus.CREATED)

    //TODO: actualizamos una categoria por su id
    @PutMapping("/category/{id}")
    public String saveUpdateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category) {

        String message = "";
        try {
            if (categoryService.getCategoryById(categoryId).isPresent()) {
                categoryService.saveOrUpdate(category);
                message = "Categoria actualizada correctamente";
            } else {
                message = "Categoria no existe";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }


    //TODO: enviamos como parametros el id de la categoria para eliminar una categoria
    @DeleteMapping("/category/{id}")
    public String delete(@PathVariable("id") Long categoryId) {
        categoryService.delete(categoryId);
        return "Categoria eliminada correctamente";
    }


}
