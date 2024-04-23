package com.munievents.munievents.service;

import com.munievents.munievents.entity.Category;
import com.munievents.munievents.entity.Event;
import com.munievents.munievents.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    //TODO: retornamos todas las
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    //TODO: buscamos una categoria por su id
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    //TODO:guarda o actualiza la categoria
    @PostMapping
    public void saveOrUpdate(@RequestBody Category category) {
        categoryRepository.save(category);
    }


    //TODO: elimina una categoria por su id
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
