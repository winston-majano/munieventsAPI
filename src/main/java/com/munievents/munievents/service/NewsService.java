package com.munievents.munievents.service;

import com.munievents.munievents.entity.News;
import com.munievents.munievents.repository.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    INewsRepository newsRepository;

    //TODO: retornamos todos los eventos
    @GetMapping
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    //TODO: buscamos un evento por su id
    @GetMapping
    public Optional<News> getNews(int id) {
        return newsRepository.findById(id);
    }
   
    //TODO:guarda o actualiza el evento
    @PostMapping
    public void saveOrUpdate(@RequestBody News newsId) {
        newsRepository.save(newsId);
    }


    //TODO: elimina un evento por su id
    public void delete(int id) {
        newsRepository.deleteById(id);
    }

    @PutMapping
    public void updateNews(@RequestBody News newsId) {
        newsRepository.save(newsId);
    }

}
